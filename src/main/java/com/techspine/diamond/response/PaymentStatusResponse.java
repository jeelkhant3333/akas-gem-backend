package com.techspine.diamond.response;

import com.techspine.diamond.entity.PaymentStatusMaster;
import com.techspine.diamond.projection.PaymentStatusProjection;

public class PaymentStatusResponse {

    private Long id;
    private String status;

    public PaymentStatusResponse(PaymentStatusMaster p) {
        this.id = p.getId();
        this.status = p.getStatus();
    }

    public PaymentStatusResponse(PaymentStatusProjection p) {
        this.id = p.getId();
        this.status = p.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
