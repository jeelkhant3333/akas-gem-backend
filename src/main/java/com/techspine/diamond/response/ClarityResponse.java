package com.techspine.diamond.response;

import com.techspine.diamond.entity.ClarityMaster;
import com.techspine.diamond.projection.ClarityProjection;

public class ClarityResponse {

    private Long id;
    private String clarity;

    public ClarityResponse(ClarityMaster c) {
        this.id = c.getId();
        this.clarity = c.getClarity();
    }

    public ClarityResponse(ClarityProjection p) {
        this.id = p.getId();
        this.clarity = p.getClarity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClarity() {
        return clarity;
    }

    public void setClarity(String clarity) {
        this.clarity = clarity;
    }
}
