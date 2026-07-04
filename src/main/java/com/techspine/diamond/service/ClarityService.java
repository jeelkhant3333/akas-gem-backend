package com.techspine.diamond.service;

import com.techspine.diamond.entity.ClarityMaster;
import com.techspine.diamond.projection.ClarityProjection;
import com.techspine.diamond.repository.ClarityRepository;
import com.techspine.diamond.request.ClarityRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ClarityDataListResponse;
import com.techspine.diamond.response.ClarityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClarityService {

    private final ClarityRepository clarityRepository;

    @Autowired
    public ClarityService(ClarityRepository clarityRepository) {
        this.clarityRepository = clarityRepository;
    }

    public ApiResponse<String> createClarity(ClarityRequest request) {
        ClarityMaster clarity = new ClarityMaster();
        clarity.setClarity(request.getClarity());
        clarityRepository.save(clarity);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<ClarityDataListResponse> getAllClarities(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<ClarityProjection> page = clarityRepository.findAllClarities(request.getSearch(), pageable);

        List<ClarityResponse> dataList = page.getContent().stream().map(ClarityResponse::new).toList();

        ClarityDataListResponse paginationResponse = new ClarityDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Clarities fetched successfully", paginationResponse);
    }

    public ApiResponse<ClarityResponse> getClarityById(Long id) {
        ClarityMaster clarity = clarityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clarity not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new ClarityResponse(clarity));
    }

    public ApiResponse<String> updateClarity(Long id, ClarityRequest request) {
        ClarityMaster clarity = clarityRepository.findById(id).orElse(null);
        if (clarity == null) {
            return new ApiResponse<>(0, "Clarity not found for id = " + id, null);
        }
        clarity.setClarity(request.getClarity());
        clarityRepository.save(clarity);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteClarity(Long id) {
        clarityRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

