package com.techspine.diamond.service;

import com.techspine.diamond.entity.TermsMaster;
import com.techspine.diamond.projection.TermsProjection;
import com.techspine.diamond.repository.TermsRepository;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.TermsRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.TermsDataListResponse;
import com.techspine.diamond.response.TermsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsService {

    private final TermsRepository termsRepository;

    @Autowired
    public TermsService(TermsRepository termsRepository) {
        this.termsRepository = termsRepository;
    }

    public ApiResponse<String> createTerms(TermsRequest request) {
        TermsMaster terms = new TermsMaster();
        terms.setTermsName(request.getTermsName());
        terms.setDescription(request.getDescription());
        termsRepository.save(terms);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<TermsDataListResponse> getAllTerms(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<TermsProjection> page = termsRepository.findAllTerms(request.getSearch(), pageable);

        List<TermsResponse> dataList = page.getContent().stream().map(TermsResponse::new).toList();

        TermsDataListResponse paginationResponse = new TermsDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Terms fetched successfully", paginationResponse);
    }

    public ApiResponse<TermsResponse> getTermsById(Long id) {
        TermsMaster terms = termsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Terms not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new TermsResponse(terms));
    }

    public ApiResponse<String> updateTerms(Long id, TermsRequest request) {
        TermsMaster terms = termsRepository.findById(id).orElse(null);
        if (terms == null) {
            return new ApiResponse<>(0, "Terms not found for id = " + id, null);
        }
        terms.setTermsName(request.getTermsName());
        terms.setDescription(request.getDescription());
        termsRepository.save(terms);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteTerms(Long id) {
        termsRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

