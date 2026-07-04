package com.techspine.diamond.controller;

import com.techspine.diamond.request.LabRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.LabDataListResponse;
import com.techspine.diamond.response.LabResponse;
import com.techspine.diamond.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/labs")
public class LabController {

    @Autowired
    private LabService labService;

    @PostMapping
    public ApiResponse<String> createLab(@RequestBody LabRequest request) {
        return labService.createLab(request);
    }

    @PostMapping("/list")
    public ApiResponse<LabDataListResponse> getAllLabs(@RequestBody PaginationRequest request) {
        return labService.getAllLabs(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<LabResponse> getLabById(@PathVariable Long id) {
        return labService.getLabById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateLab(@PathVariable Long id, @RequestBody LabRequest request) {
        return labService.updateLab(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteLab(@PathVariable Long id) {
        return labService.deleteLab(id);
    }
}

