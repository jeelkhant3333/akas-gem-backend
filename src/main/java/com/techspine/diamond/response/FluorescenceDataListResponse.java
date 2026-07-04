package com.techspine.diamond.response;

import java.util.List;

public class FluorescenceDataListResponse extends PaginationResponse {

    private List<FluorescenceResponse> dataList;

    public FluorescenceDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<FluorescenceResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<FluorescenceResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<FluorescenceResponse> dataList) {
        this.dataList = dataList;
    }
}

