package com.techspine.diamond.response;

import com.techspine.diamond.entity.CutMaster;
import com.techspine.diamond.projection.CutProjection;

public class CutResponse {

    private Long id;
    private String cut;

    public CutResponse(CutMaster c) {
        this.id = c.getId();
        this.cut = c.getCut();
    }

    public CutResponse(CutProjection p) {
        this.id = p.getId();
        this.cut = p.getCut();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }
}
