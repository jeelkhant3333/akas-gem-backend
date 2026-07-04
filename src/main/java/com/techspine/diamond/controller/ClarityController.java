package com.techspine.diamond.controller;

import com.techspine.diamond.request.ClarityRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ClarityDataListResponse;
import com.techspine.diamond.response.ClarityResponse;
import com.techspine.diamond.service.ClarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clarities")
public class ClarityController {

    @Autowired
    private ClarityService clarityService;

    @PostMapping
    public ApiResponse<String> createClarity(@RequestBody ClarityRequest request) {
        return clarityService.createClarity(request);
    }

    @PostMapping("/list")
    public ApiResponse<ClarityDataListResponse> getAllClarities(@RequestBody PaginationRequest request) {
        return clarityService.getAllClarities(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<ClarityResponse> getClarityById(@PathVariable Long id) {
        return clarityService.getClarityById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateClarity(@PathVariable Long id, @RequestBody ClarityRequest request) {
        return clarityService.updateClarity(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteClarity(@PathVariable Long id) {
        return clarityService.deleteClarity(id);
    }
}

