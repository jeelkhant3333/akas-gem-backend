package com.techspine.diamond.response;

import com.techspine.diamond.entity.LocationMaster;
import com.techspine.diamond.projection.LocationProjection;

public class LocationResponse {

    private Long id;
    private String location;

    public LocationResponse(LocationMaster l) {
        this.id = l.getId();
        this.location = l.getLocation();
    }

    public LocationResponse(LocationProjection p) {
        this.id = p.getId();
        this.location = p.getLocation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
