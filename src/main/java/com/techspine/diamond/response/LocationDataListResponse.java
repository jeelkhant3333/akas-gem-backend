package com.techspine.diamond.response;

import java.util.List;

public class LocationDataListResponse extends PaginationResponse {

    private List<LocationResponse> dataList;

    public LocationDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<LocationResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<LocationResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<LocationResponse> dataList) {
        this.dataList = dataList;
    }
}

