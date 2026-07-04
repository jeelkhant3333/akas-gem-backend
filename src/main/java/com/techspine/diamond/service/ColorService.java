package com.techspine.diamond.service;

import com.techspine.diamond.entity.ColorMaster;
import com.techspine.diamond.projection.ColorProjection;
import com.techspine.diamond.repository.ColorRepository;
import com.techspine.diamond.request.ColorRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.ColorDataListResponse;
import com.techspine.diamond.response.ColorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    private final ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public ApiResponse<String> createColor(ColorRequest request) {
        ColorMaster color = new ColorMaster();
        color.setColor(request.getColor());
        colorRepository.save(color);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<ColorDataListResponse> getAllColors(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<ColorProjection> page = colorRepository.findAllColors(request.getSearch(), pageable);

        List<ColorResponse> dataList = page.getContent().stream().map(ColorResponse::new).toList();

        ColorDataListResponse paginationResponse = new ColorDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Colors fetched successfully", paginationResponse);
    }

    public ApiResponse<ColorResponse> getColorById(Long id) {
        ColorMaster color = colorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Color not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new ColorResponse(color));
    }

    public ApiResponse<String> updateColor(Long id, ColorRequest request) {
        ColorMaster color = colorRepository.findById(id).orElse(null);
        if (color == null) {
            return new ApiResponse<>(0, "Color not found for id = " + id, null);
        }
        color.setColor(request.getColor());
        colorRepository.save(color);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteColor(Long id) {
        colorRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

