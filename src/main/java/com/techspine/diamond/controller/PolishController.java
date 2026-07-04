package com.techspine.diamond.controller;

import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.PolishRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.PolishDataListResponse;
import com.techspine.diamond.response.PolishResponse;
import com.techspine.diamond.service.PolishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/polishes")
public class PolishController {

    @Autowired
    private PolishService polishService;

    @PostMapping
    public ApiResponse<String> createPolish(@RequestBody PolishRequest request) {
        return polishService.createPolish(request);
    }

    @PostMapping("/list")
    public ApiResponse<PolishDataListResponse> getAllPolishes(@RequestBody PaginationRequest request) {
        return polishService.getAllPolishes(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<PolishResponse> getPolishById(@PathVariable Long id) {
        return polishService.getPolishById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updatePolish(@PathVariable Long id, @RequestBody PolishRequest request) {
        return polishService.updatePolish(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePolish(@PathVariable Long id) {
        return polishService.deletePolish(id);
    }
}

