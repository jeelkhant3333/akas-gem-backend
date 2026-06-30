package com.techspine.diamond.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terms_master")
public class TermsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "terms_name")
    private String termsName;

    private String description;

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