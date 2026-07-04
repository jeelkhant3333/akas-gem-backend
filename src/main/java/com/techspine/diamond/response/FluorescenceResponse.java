package com.techspine.diamond.response;

import com.techspine.diamond.entity.FluorescenceMaster;
import com.techspine.diamond.projection.FluorescenceProjection;

public class FluorescenceResponse {

    private Long id;
    private String fluorescence;

    public FluorescenceResponse(FluorescenceMaster f) {
        this.id = f.getId();
        this.fluorescence = f.getFluorescence();
    }

    public FluorescenceResponse(FluorescenceProjection p) {
        this.id = p.getId();
        this.fluorescence = p.getFluorescence();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFluorescence() {
        return fluorescence;
    }

    public void setFluorescence(String fluorescence) {
        this.fluorescence = fluorescence;
    }
}
