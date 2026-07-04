package com.techspine.diamond.service;

import com.techspine.diamond.entity.PaymentStatusMaster;
import com.techspine.diamond.projection.PaymentStatusProjection;
import com.techspine.diamond.repository.PaymentStatusRepository;
import com.techspine.diamond.request.PaginationRequest;
import com.techspine.diamond.request.PaymentStatusRequest;
import com.techspine.diamond.response.ApiResponse;
import com.techspine.diamond.response.PaymentStatusDataListResponse;
import com.techspine.diamond.response.PaymentStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentStatusService {

    private final PaymentStatusRepository paymentStatusRepository;

    @Autowired
    public PaymentStatusService(PaymentStatusRepository paymentStatusRepository) {
        this.paymentStatusRepository = paymentStatusRepository;
    }

    public ApiResponse<String> createPaymentStatus(PaymentStatusRequest request) {
        PaymentStatusMaster paymentStatus = new PaymentStatusMaster();
        paymentStatus.setStatus(request.getStatus());
        paymentStatusRepository.save(paymentStatus);
        return new ApiResponse<>(1, "Item added successfully", null);
    }

    public ApiResponse<PaymentStatusDataListResponse> getAllPaymentStatuses(PaginationRequest request) {
        Sort sort = request.getSortDir().equalsIgnoreCase("asc")
                ? Sort.by(request.getSortBy()).ascending()
                : Sort.by(request.getSortBy()).descending();

        Pageable pageable = PageRequest.of(request.getPageNo(), request.getPageSize(), sort);
        Page<PaymentStatusProjection> page = paymentStatusRepository.findAllPaymentStatuses(request.getSearch(), pageable);

        List<PaymentStatusResponse> dataList = page.getContent().stream().map(PaymentStatusResponse::new).toList();

        PaymentStatusDataListResponse paginationResponse = new PaymentStatusDataListResponse(
                page.getTotalElements(), page.getTotalPages(),
                page.getNumber(), page.getSize(), dataList);

        return new ApiResponse<>(1, "Payment Statuses fetched successfully", paginationResponse);
    }

    public ApiResponse<PaymentStatusResponse> getPaymentStatusById(Long id) {
        PaymentStatusMaster paymentStatus = paymentStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Status not found with id : " + id));
        return new ApiResponse<>(1, "Item fetched successfully", new PaymentStatusResponse(paymentStatus));
    }

    public ApiResponse<String> updatePaymentStatus(Long id, PaymentStatusRequest request) {
        PaymentStatusMaster paymentStatus = paymentStatusRepository.findById(id).orElse(null);
        if (paymentStatus == null) {
            return new ApiResponse<>(0, "Payment Status not found for id = " + id, null);
        }
        paymentStatus.setStatus(request.getStatus());
        paymentStatusRepository.save(paymentStatus);
        return new ApiResponse<>(1, "Item updated successfully", null);
    }

    public ApiResponse<String> deletePaymentStatus(Long id) {
        paymentStatusRepository.deleteById(id);
        return new ApiResponse<>(1, "Item deleted successfully", null);
    }
}

