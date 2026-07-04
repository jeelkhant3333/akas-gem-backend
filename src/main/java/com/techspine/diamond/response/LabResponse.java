package com.techspine.diamond.response;

import com.techspine.diamond.entity.LabMaster;
import com.techspine.diamond.projection.LabProjection;

public class LabResponse {

    private Long id;
    private String labName;

    public LabResponse(LabMaster l) {
        this.id = l.getId();
        this.labName = l.getLabName();
    }

    public LabResponse(LabProjection p) {
        this.id = p.getId();
        this.labName = p.getLabName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}
