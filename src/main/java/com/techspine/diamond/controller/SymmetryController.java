package com.techspine.diamond.controller;

import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.SymmetryRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.SymmetryDataListResponse;
import com.techspine.diamond.response.SymmetryResponse;
import com.techspine.diamond.service.SymmetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/symmetries")
public class SymmetryController {

    @Autowired
    private SymmetryService symmetryService;

    @PostMapping
    public ApiResponse<String> createSymmetry(@RequestBody SymmetryRequest request) {
        return symmetryService.createSymmetry(request);
    }

    @PostMapping("/list")
    public ApiResponse<SymmetryDataListResponse> getAllSymmetries(@RequestBody PaginationRequest request) {
        return symmetryService.getAllSymmetries(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<SymmetryResponse> getSymmetryById(@PathVariable Long id) {
        return symmetryService.getSymmetryById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateSymmetry(@PathVariable Long id, @RequestBody SymmetryRequest request) {
        return symmetryService.updateSymmetry(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteSymmetry(@PathVariable Long id) {
        return symmetryService.deleteSymmetry(id);
    }
}

