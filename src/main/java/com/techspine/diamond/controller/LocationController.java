package com.techspine.diamond.controller;

import com.techspine.diamond.request.LocationRequest;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.LocationDataListResponse;
import com.techspine.diamond.response.LocationResponse;
import com.techspine.diamond.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public ApiResponse<String> createLocation(@RequestBody LocationRequest request) {
        return locationService.createLocation(request);
    }

    @PostMapping("/list")
    public ApiResponse<LocationDataListResponse> getAllLocations(@RequestBody PaginationRequest request) {
        return locationService.getAllLocations(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<LocationResponse> getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updateLocation(@PathVariable Long id, @RequestBody LocationRequest request) {
        return locationService.updateLocation(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteLocation(@PathVariable Long id) {
        return locationService.deleteLocation(id);
    }
}

