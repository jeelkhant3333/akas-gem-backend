package com.techspine.diamond.response;

import java.util.List;

public class PaymentStatusDataListResponse extends PaginationResponse {

    private List<PaymentStatusResponse> dataList;

    public PaymentStatusDataListResponse(long totalElements, int totalPages, int pageNo, int pageSize, List<PaymentStatusResponse> dataList) {
        super(totalElements, totalPages, pageNo, pageSize);
        this.dataList = dataList;
    }

    public List<PaymentStatusResponse> getDataList() {
        return dataList;
    }

    public void setDataList(List<PaymentStatusResponse> dataList) {
        this.dataList = dataList;
    }
}

