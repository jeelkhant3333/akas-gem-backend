package com.techspine.diamond.response;

import com.techspine.diamond.entity.ShapeMaster;
import com.techspine.diamond.projection.ShapeProjection;

public class ShapeResponse {

    private Long id;
    private String shapeName;

    public ShapeResponse(ShapeMaster s) {
        this.id = s.getId();
        this.shapeName = s.getShapeName();
    }

    public ShapeResponse(ShapeProjection p) {
        this.id = p.getId();
        this.shapeName = p.getShapeName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}
