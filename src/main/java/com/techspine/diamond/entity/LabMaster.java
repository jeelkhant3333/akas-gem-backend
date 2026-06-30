package com.techspine.diamond.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_master")
public class LabMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lab_name")
    private String labName;

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