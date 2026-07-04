package com.techspine.diamond.response;

import java.util.List;

public class PolishDataListResponse extends PaginationResponse {

    private List<PolishResponse> dataList;

    public PolishDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<PolishResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<PolishResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<PolishResponse> dataList) {
        this.dataList = dataList;
    }
}

