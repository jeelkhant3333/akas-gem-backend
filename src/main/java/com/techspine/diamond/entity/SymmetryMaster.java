package com.techspine.diamond.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "symmetry_master")
public class SymmetryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symmetry;

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