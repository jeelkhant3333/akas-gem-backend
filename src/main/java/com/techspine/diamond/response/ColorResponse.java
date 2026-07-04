package com.techspine.diamond.response;

import com.techspine.diamond.entity.ColorMaster;
import com.techspine.diamond.projection.ColorProjection;

public class ColorResponse {

    private Long id;
    private String color;

    public ColorResponse(ColorMaster c) {
        this.id = c.getId();
        this.color = c.getColor();
    }

    public ColorResponse(ColorProjection p) {
        this.id = p.getId();
        this.color = p.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
