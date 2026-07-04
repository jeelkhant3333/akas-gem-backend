package com.techspine.diamond.service;

import com.techspine.diamond.entity.LocationMaster;
import com.techspine.diamond.projection.LocationProjection;
import com.techspine.diamond.repository.LocationRepository;
import com.techspine.diamond.request.LocationRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.LocationDataListResponse;
import com.techspine.diamond.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public ApiResponse<String> createLocation(LocationRequest request) {
        LocationMaster location = new LocationMaster();
        location.setLocation(request.getLocation());
        locationRepository.save(location);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<LocationDataListResponse> getAllLocations(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<LocationProjection> page = locationRepository.findAllLocations(request.getSearch(), pageable);

        List<LocationResponse> dataList = page.getContent().stream().map(LocationResponse::new).toList();

        LocationDataListResponse paginationResponse = new LocationDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Locations fetched successfully", paginationResponse);
    }

    public ApiResponse<LocationResponse> getLocationById(Long id) {
        LocationMaster location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new LocationResponse(location));
    }

    public ApiResponse<String> updateLocation(Long id, LocationRequest request) {
        LocationMaster location = locationRepository.findById(id).orElse(null);
        if (location == null) {
            return new ApiResponse<>(0, "Location not found for id = " + id, null);
        }
        location.setLocation(request.getLocation());
        locationRepository.save(location);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

