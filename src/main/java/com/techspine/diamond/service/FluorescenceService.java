package com.techspine.diamond.service;

import com.techspine.diamond.entity.FluorescenceMaster;
import com.techspine.diamond.projection.FluorescenceProjection;
import com.techspine.diamond.repository.FluorescenceRepository;
import com.techspine.diamond.request.FluorescenceRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.FluorescenceDataListResponse;
import com.techspine.diamond.response.FluorescenceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FluorescenceService {

    private final FluorescenceRepository fluorescenceRepository;

    @Autowired
    public FluorescenceService(FluorescenceRepository fluorescenceRepository) {
        this.fluorescenceRepository = fluorescenceRepository;
    }

    public ApiResponse<String> createFluorescence(FluorescenceRequest request) {
        FluorescenceMaster fluorescence = new FluorescenceMaster();
        fluorescence.setFluorescence(request.getFluorescence());
        fluorescenceRepository.save(fluorescence);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<FluorescenceDataListResponse> getAllFluorescences(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<FluorescenceProjection> page = fluorescenceRepository.findAllFluorescences(request.getSearch(), pageable);

        List<FluorescenceResponse> dataList = page.getContent().stream().map(FluorescenceResponse::new).toList();

        FluorescenceDataListResponse paginationResponse = new FluorescenceDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Fluorescences fetched successfully", paginationResponse);
    }

    public ApiResponse<FluorescenceResponse> getFluorescenceById(Long id) {
        FluorescenceMaster fluorescence = fluorescenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fluorescence not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new FluorescenceResponse(fluorescence));
    }

    public ApiResponse<String> updateFluorescence(Long id, FluorescenceRequest request) {
        FluorescenceMaster fluorescence = fluorescenceRepository.findById(id).orElse(null);
        if (fluorescence == null) {
            return new ApiResponse<>(0, "Fluorescence not found for id = " + id, null);
        }
        fluorescence.setFluorescence(request.getFluorescence());
        fluorescenceRepository.save(fluorescence);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteFluorescence(Long id) {
        fluorescenceRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

