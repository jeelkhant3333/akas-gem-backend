package com.techspine.diamond.response;

import java.util.List;

public class ShapeDataListResponse extends PaginationResponse {

    private List<ShapeResponse> dataList;

    public ShapeDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<ShapeResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<ShapeResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<ShapeResponse> dataList) {
        this.dataList = dataList;
    }
}

