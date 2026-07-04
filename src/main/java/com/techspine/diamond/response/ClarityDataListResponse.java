package com.techspine.diamond.response;

import java.util.List;

public class ClarityDataListResponse extends PaginationResponse {

    private List<ClarityResponse> dataList;

    public ClarityDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<ClarityResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<ClarityResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<ClarityResponse> dataList) {
        this.dataList = dataList;
    }
}

