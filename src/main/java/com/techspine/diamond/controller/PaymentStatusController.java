package com.techspine.diamond.controller;

import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.PaymentStatusRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.PaymentStatusDataListResponse;
import com.techspine.diamond.response.PaymentStatusResponse;
import com.techspine.diamond.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment-statuses")
public class PaymentStatusController {

    @Autowired
    private PaymentStatusService paymentStatusService;

    @PostMapping
    public ApiResponse<String> createPaymentStatus(@RequestBody PaymentStatusRequest request) {
        return paymentStatusService.createPaymentStatus(request);
    }

    @PostMapping("/list")
    public ApiResponse<PaymentStatusDataListResponse> getAllPaymentStatuses(@RequestBody PaginationRequest request) {
        return paymentStatusService.getAllPaymentStatuses(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<PaymentStatusResponse> getPaymentStatusById(@PathVariable Long id) {
        return paymentStatusService.getPaymentStatusById(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> updatePaymentStatus(@PathVariable Long id, @RequestBody PaymentStatusRequest request) {
        return paymentStatusService.updatePaymentStatus(id, request);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePaymentStatus(@PathVariable Long id) {
        return paymentStatusService.deletePaymentStatus(id);
    }
}

