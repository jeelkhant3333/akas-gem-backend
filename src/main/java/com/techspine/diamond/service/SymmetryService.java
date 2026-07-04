package com.techspine.diamond.service;

import com.techspine.diamond.entity.SymmetryMaster;
import com.techspine.diamond.projection.SymmetryProjection;
import com.techspine.diamond.repository.SymmetryRepository;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.SymmetryRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.SymmetryDataListResponse;
import com.techspine.diamond.response.SymmetryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymmetryService {

    private final SymmetryRepository symmetryRepository;

    @Autowired
    public SymmetryService(SymmetryRepository symmetryRepository) {
        this.symmetryRepository = symmetryRepository;
    }

    public ApiResponse<String> createSymmetry(SymmetryRequest request) {
        SymmetryMaster symmetry = new SymmetryMaster();
        symmetry.setSymmetry(request.getSymmetry());
        symmetryRepository.save(symmetry);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<SymmetryDataListResponse> getAllSymmetries(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<SymmetryProjection> page = symmetryRepository.findAllSymmetries(request.getSearch(), pageable);

        List<SymmetryResponse> dataList = page.getContent().stream().map(SymmetryResponse::new).toList();

        SymmetryDataListResponse paginationResponse = new SymmetryDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Symmetries fetched successfully", paginationResponse);
    }

    public ApiResponse<SymmetryResponse> getSymmetryById(Long id) {
        SymmetryMaster symmetry = symmetryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Symmetry not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new SymmetryResponse(symmetry));
    }

    public ApiResponse<String> updateSymmetry(Long id, SymmetryRequest request) {
        SymmetryMaster symmetry = symmetryRepository.findById(id).orElse(null);
        if (symmetry == null) {
            return new ApiResponse<>(0, "Symmetry not found for id = " + id, null);
        }
        symmetry.setSymmetry(request.getSymmetry());
        symmetryRepository.save(symmetry);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteSymmetry(Long id) {
        symmetryRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

