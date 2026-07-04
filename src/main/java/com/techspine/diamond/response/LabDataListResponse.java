package com.techspine.diamond.response;

import java.util.List;

public class LabDataListResponse extends PaginationResponse {

    private List<LabResponse> dataList;

    public LabDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<LabResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<LabResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<LabResponse> dataList) {
        this.dataList = dataList;
    }
}

