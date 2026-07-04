package com.techspine.diamond.service;

import com.techspine.diamond.entity.PolishMaster;
import com.techspine.diamond.projection.PolishProjection;
import com.techspine.diamond.repository.PolishRepository;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.PolishRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.PolishDataListResponse;
import com.techspine.diamond.response.PolishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolishService {

    private final PolishRepository polishRepository;

    @Autowired
    public PolishService(PolishRepository polishRepository) {
        this.polishRepository = polishRepository;
    }

    public ApiResponse<String> createPolish(PolishRequest request) {
        PolishMaster polish = new PolishMaster();
        polish.setPolish(request.getPolish());
        polishRepository.save(polish);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<PolishDataListResponse> getAllPolishes(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<PolishProjection> page = polishRepository.findAllPolishes(request.getSearch(), pageable);

        List<PolishResponse> dataList = page.getContent().stream().map(PolishResponse::new).toList();

        PolishDataListResponse paginationResponse = new PolishDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Polishes fetched successfully", paginationResponse);
    }

    public ApiResponse<PolishResponse> getPolishById(Long id) {
        PolishMaster polish = polishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Polish not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new PolishResponse(polish));
    }

    public ApiResponse<String> updatePolish(Long id, PolishRequest request) {
        PolishMaster polish = polishRepository.findById(id).orElse(null);
        if (polish == null) {
            return new ApiResponse<>(0, "Polish not found for id = " + id, null);
        }
        polish.setPolish(request.getPolish());
        polishRepository.save(polish);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deletePolish(Long id) {
        polishRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

