package com.techspine.diamond.response;

import com.techspine.diamond.entity.PolishMaster;
import com.techspine.diamond.projection.PolishProjection;

public class PolishResponse {

    private Long id;
    private String polish;

    public PolishResponse(PolishMaster p) {
        this.id = p.getId();
        this.polish = p.getPolish();
    }

    public PolishResponse(PolishProjection p) {
        this.id = p.getId();
        this.polish = p.getPolish();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }
}
