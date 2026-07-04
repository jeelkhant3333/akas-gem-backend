package com.techspine.diamond.response;

import java.util.List;

public class SymmetryDataListResponse extends PaginationResponse {

    private List<SymmetryResponse> dataList;

    public SymmetryDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<SymmetryResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<SymmetryResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<SymmetryResponse> dataList) {
        this.dataList = dataList;
    }
}

