package com.techspine.diamond.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fluorescence_master")
public class FluorescenceMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fluorescence;

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