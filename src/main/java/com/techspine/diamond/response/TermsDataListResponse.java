package com.techspine.diamond.response;

import java.util.List;

public class TermsDataListResponse extends PaginationResponse {

    private List<TermsResponse> dataList;

    public TermsDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<TermsResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<TermsResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<TermsResponse> dataList) {
        this.dataList = dataList;
    }
}

