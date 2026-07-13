package com.techspine.diamond.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class StoneListRequest extends PaginationRequest {

    private Long shapeId;
    private Long colorId;
    private Long clarityId;
    private Long cutId;
    private Long polishId;
    private Long symmetryId;
    private Long fluorescenceId;
    private Long labId;
    private Long paymentStatusId;
    private Long locationId;
    private Long termsId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fromDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate toDate;

    public Long getShapeId() {
        return shapeId;
    }

    public void setShapeId(Long shapeId) {
        this.shapeId = shapeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getClarityId() {
        return clarityId;
    }

    public void setClarityId(Long clarityId) {
        this.clarityId = clarityId;
    }

    public Long getCutId() {
        return cutId;
    }

    public void setCutId(Long cutId) {
        this.cutId = cutId;
    }

    public Long getPolishId() {
        return polishId;
    }

    public void setPolishId(Long polishId) {
        this.polishId = polishId;
    }

    public Long getSymmetryId() {
        return symmetryId;
    }

    public void setSymmetryId(Long symmetryId) {
        this.symmetryId = symmetryId;
    }

    public Long getFluorescenceId() {
        return fluorescenceId;
    }

    public void setFluorescenceId(Long fluorescenceId) {
        this.fluorescenceId = fluorescenceId;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public Long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getTermsId() {
        return termsId;
    }

    public void setTermsId(Long termsId) {
        this.termsId = termsId;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
