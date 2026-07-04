package com.techspine.diamond.response;

import java.util.List;

public class ColorDataListResponse extends PaginationResponse {

    private List<ColorResponse> dataList;

    public ColorDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<ColorResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<ColorResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<ColorResponse> dataList) {
        this.dataList = dataList;
    }
}

