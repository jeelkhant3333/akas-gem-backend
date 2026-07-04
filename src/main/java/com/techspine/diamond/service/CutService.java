package com.techspine.diamond.service;

import com.techspine.diamond.entity.CutMaster;
import com.techspine.diamond.projection.CutProjection;
import com.techspine.diamond.repository.CutRepository;
import com.techspine.diamond.request.CutRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.CutDataListResponse;
import com.techspine.diamond.response.CutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutService {

    private final CutRepository cutRepository;

    @Autowired
    public CutService(CutRepository cutRepository) {
        this.cutRepository = cutRepository;
    }

    public ApiResponse<String> createCut(CutRequest request) {
        CutMaster cut = new CutMaster();
        cut.setCut(request.getCut());
        cutRepository.save(cut);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<CutDataListResponse> getAllCuts(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<CutProjection> page = cutRepository.findAllCuts(request.getSearch(), pageable);

        List<CutResponse> dataList = page.getContent().stream().map(CutResponse::new).toList();

        CutDataListResponse paginationResponse = new CutDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Cuts fetched successfully", paginationResponse);
    }

    public ApiResponse<CutResponse> getCutById(Long id) {
        CutMaster cut = cutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cut not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new CutResponse(cut));
    }

    public ApiResponse<String> updateCut(Long id, CutRequest request) {
        CutMaster cut = cutRepository.findById(id).orElse(null);
        if (cut == null) {
            return new ApiResponse<>(0, "Cut not found for id = " + id, null);
        }
        cut.setCut(request.getCut());
        cutRepository.save(cut);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteCut(Long id) {
        cutRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

