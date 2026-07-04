package com.techspine.diamond.controller;

import com.techspine.diamond.request.ColorRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ColorDataListResponse;
import com.techspine.diamond.response.ColorResponse;
import com.techspine.diamond.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @PostMapping
    public ApiResponse<String> createColor(@RequestBody ColorRequest request) {
        return colorService.createColor(request);
    }

    @PostMapping("/list")
    public ApiResponse<ColorDataListResponse> getAllColors(@RequestBody PaginationRequest request) {
        return colorService.getAllColors(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<ColorResponse> getColorById(@PathVariable Long id) {
        return colorService.getColorById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateColor(@PathVariable Long id, @RequestBody ColorRequest request) {
        return colorService.updateColor(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteColor(@PathVariable Long id) {
        return colorService.deleteColor(id);
    }
}

