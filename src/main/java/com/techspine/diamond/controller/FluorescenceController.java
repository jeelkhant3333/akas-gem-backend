package com.techspine.diamond.controller;

import com.techspine.diamond.request.FluorescenceRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.FluorescenceDataListResponse;
import com.techspine.diamond.response.FluorescenceResponse;
import com.techspine.diamond.service.FluorescenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fluorescences")
public class FluorescenceController {

    @Autowired
    private FluorescenceService fluorescenceService;

    @PostMapping
    public ApiResponse<String> createFluorescence(@RequestBody FluorescenceRequest request) {
        return fluorescenceService.createFluorescence(request);
    }

    @PostMapping("/list")
    public ApiResponse<FluorescenceDataListResponse> getAllFluorescences(@RequestBody PaginationRequest request) {
        return fluorescenceService.getAllFluorescences(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<FluorescenceResponse> getFluorescenceById(@PathVariable Long id) {
        return fluorescenceService.getFluorescenceById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateFluorescence(@PathVariable Long id, @RequestBody FluorescenceRequest request) {
        return fluorescenceService.updateFluorescence(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteFluorescence(@PathVariable Long id) {
        return fluorescenceService.deleteFluorescence(id);
    }
}

