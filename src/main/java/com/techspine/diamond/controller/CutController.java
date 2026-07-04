package com.techspine.diamond.controller;

import com.techspine.diamond.request.CutRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.CutDataListResponse;
import com.techspine.diamond.response.CutResponse;
import com.techspine.diamond.service.CutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cuts")
public class CutController {

    @Autowired
    private CutService cutService;

    @PostMapping
    public ApiResponse<String> createCut(@RequestBody CutRequest request) {
        return cutService.createCut(request);
    }

    @PostMapping("/list")
    public ApiResponse<CutDataListResponse> getAllCuts(@RequestBody PaginationRequest request) {
        return cutService.getAllCuts(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<CutResponse> getCutById(@PathVariable Long id) {
        return cutService.getCutById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateCut(@PathVariable Long id, @RequestBody CutRequest request) {
        return cutService.updateCut(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteCut(@PathVariable Long id) {
        return cutService.deleteCut(id);
    }
}

