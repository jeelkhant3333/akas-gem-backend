package com.techspine.diamond.controller;

import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.ShapeRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ShapeDataListResponse;
import com.techspine.diamond.response.ShapeResponse;
import com.techspine.diamond.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {

    @Autowired
    private ShapeService shapeService;

    @PostMapping
    public ApiResponse<String> createShape(@RequestBody ShapeRequest request) {
        return shapeService.createShape(request);
    }

    @PostMapping("/list")
    public ApiResponse<ShapeDataListResponse> getAllShapes(@RequestBody PaginationRequest request) {
        return shapeService.getAllShapes(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<ShapeResponse> getShapeById(@PathVariable Long id) {
        return shapeService.getShapeById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateShape(@PathVariable Long id, @RequestBody ShapeRequest request) {
        return shapeService.updateShape(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteShape(@PathVariable Long id) {
        return shapeService.deleteShape(id);
    }
}

