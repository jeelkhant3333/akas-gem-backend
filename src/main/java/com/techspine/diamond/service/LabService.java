package com.techspine.diamond.service;

import com.techspine.diamond.entity.LabMaster;
import com.techspine.diamond.projection.LabProjection;
import com.techspine.diamond.repository.LabRepository;
import com.techspine.diamond.request.LabRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.LabDataListResponse;
import com.techspine.diamond.response.LabResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabService {

    private final LabRepository labRepository;

    @Autowired
    public LabService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public ApiResponse<String> createLab(LabRequest request) {
        LabMaster lab = new LabMaster();
        lab.setLabName(request.getLabName());
        labRepository.save(lab);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<LabDataListResponse> getAllLabs(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<LabProjection> page = labRepository.findAllLabs(request.getSearch(), pageable);

        List<LabResponse> dataList = page.getContent().stream().map(LabResponse::new).toList();

        LabDataListResponse paginationResponse = new LabDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Labs fetched successfully", paginationResponse);
    }

    public ApiResponse<LabResponse> getLabById(Long id) {
        LabMaster lab = labRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lab not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new LabResponse(lab));
    }

    public ApiResponse<String> updateLab(Long id, LabRequest request) {
        LabMaster lab = labRepository.findById(id).orElse(null);
        if (lab == null) {
            return new ApiResponse<>(0, "Lab not found for id = " + id, null);
        }
        lab.setLabName(request.getLabName());
        labRepository.save(lab);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteLab(Long id) {
        labRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

