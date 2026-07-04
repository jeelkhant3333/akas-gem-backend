package com.techspine.diamond.controller;

import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.TermsRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.TermsDataListResponse;
import com.techspine.diamond.response.TermsResponse;
import com.techspine.diamond.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/terms")
public class TermsController {

    @Autowired
    private TermsService termsService;

    @PostMapping
    public ApiResponse<String> createTerms(@RequestBody TermsRequest request) {
        return termsService.createTerms(request);
    }

    @PostMapping("/list")
    public ApiResponse<TermsDataListResponse> getAllTerms(@RequestBody PaginationRequest request) {
        return termsService.getAllTerms(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<TermsResponse> getTermsById(@PathVariable Long id) {
        return termsService.getTermsById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateTerms(@PathVariable Long id, @RequestBody TermsRequest request) {
        return termsService.updateTerms(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTerms(@PathVariable Long id) {
        return termsService.deleteTerms(id);
    }
}

