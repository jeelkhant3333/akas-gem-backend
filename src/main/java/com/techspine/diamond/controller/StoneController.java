package com.techspine.diamond.controller;

import com.techspine.diamond.request.StoneListRequest;
import com.techspine.diamond.request.StoneRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.StoneDataListResponse;
import com.techspine.diamond.response.StoneResponse;
import com.techspine.diamond.service.StoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stones")
public class StoneController {

    @Autowired
    private StoneService stoneService;

    @PostMapping
    public ApiResponse<String> createStone(@RequestBody StoneRequest request) {
        return stoneService.createStone(request);
    }

    // GET List
    @PostMapping("/list")
    public ApiResponse<StoneDataListResponse> getAllStones(@RequestBody StoneListRequest request) {

        return stoneService.getAllStones(request);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ApiResponse<StoneResponse> getStoneById(@PathVariable Long id) {
        return stoneService.getStoneById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApiResponse<String> updateStone(@PathVariable Long id, @RequestBody StoneRequest request) {
        return stoneService.updateStone(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStone(@PathVariable Long id) {
        return stoneService.deleteStone(id);
    }
}