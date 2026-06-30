package com.techspine.diamond.response;

import java.util.List;

public class StoneDataListResponse extends PaginationResponse{

    private List<StoneResponse> dataList;

    public StoneDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<StoneResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<StoneResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<StoneResponse> dataList) {
        this.dataList = dataList;
    }
}
