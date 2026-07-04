package com.techspine.diamond.response;

import com.techspine.diamond.entity.TermsMaster;
import com.techspine.diamond.projection.TermsProjection;

public class TermsResponse {

    private Long id;
    private String termsName;
    private String description;

    public TermsResponse(TermsMaster t) {
        this.id = t.getId();
        this.termsName = t.getTermsName();
        this.description = t.getDescription();
    }

    public TermsResponse(TermsProjection p) {
        this.id = p.getId();
        this.termsName = p.getTermsName();
        this.description = p.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermsName() {
        return termsName;
    }

    public void setTermsName(String termsName) {
        this.termsName = termsName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
