package com.techspine.diamond.service;

import com.techspine.diamond.entity.ShapeMaster;
import com.techspine.diamond.projection.ShapeProjection;
import com.techspine.diamond.repository.ShapeRepository;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.ShapeRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ShapeDataListResponse;
import com.techspine.diamond.response.ShapeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeService {

    private final ShapeRepository shapeRepository;

    @Autowired
    public ShapeService(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    // CREATE
    public ApiResponse<String> createShape(ShapeRequest request) {
        ShapeMaster shape = new ShapeMaster();
        shape.setShapeName(request.getShapeName());
        shapeRepository.save(shape);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    // GET ALL
    public ApiResponse<ShapeDataListResponse> getAllShapes(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);

        Page<ShapeProjection> page = shapeRepository.findAllShapes(request.getSearch(), pageable);

        List<ShapeResponse> dataList = page.getContent().stream().map(ShapeResponse::new).toList();

        ShapeDataListResponse paginationResponse = new ShapeDataListResponse(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getSize(),
                dataList
        );

        return new ApiResponse<>(1, "Shapes fetched successfully", paginationResponse);
    }

    // GET BY ID
    public ApiResponse<ShapeResponse> getShapeById(Long id) {
        ShapeMaster shape = shapeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shape not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new ShapeResponse(shape));
    }

    // UPDATE
    public ApiResponse<String> updateShape(Long id, ShapeRequest request) {
        ShapeMaster shape = shapeRepository.findById(id).orElse(null);
        if (shape == null) {
            return new ApiResponse<>(0, "Shape not found for id = " + id, null);
        }
        shape.setShapeName(request.getShapeName());
        shapeRepository.save(shape);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    // DELETE
    public ApiResponse<String> deleteShape(Long id) {
        shapeRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

