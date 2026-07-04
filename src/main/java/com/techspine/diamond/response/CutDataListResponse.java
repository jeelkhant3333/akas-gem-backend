package com.techspine.diamond.response;

import java.util.List;

public class CutDataListResponse extends PaginationResponse {

    private List<CutResponse> dataList;

    public CutDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<CutResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<CutResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<CutResponse> dataList) {
        this.dataList = dataList;
    }
}

