package com.techspine.diamond.response;

public class PaginationResponse {

    private long totalElements;

    private int totalPages;

    private int pageNo;

    private int pageSize;

    public PaginationResponse(long totalElements, int totalPages, int pageNo, int pageSize) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
