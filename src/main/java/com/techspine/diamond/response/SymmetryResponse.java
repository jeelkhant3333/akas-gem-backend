package com.techspine.diamond.response;

import com.techspine.diamond.entity.SymmetryMaster;
import com.techspine.diamond.projection.SymmetryProjection;

public class SymmetryResponse {

    private Long id;
    private String symmetry;

    public SymmetryResponse(SymmetryMaster s) {
        this.id = s.getId();
        this.symmetry = s.getSymmetry();
    }

    public SymmetryResponse(SymmetryProjection p) {
        this.id = p.getId();
        this.symmetry = p.getSymmetry();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(String symmetry) {
        this.symmetry = symmetry;
    }
}
