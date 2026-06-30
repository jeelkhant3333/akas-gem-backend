package com.techspine.diamond.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StoneRequest {

    // Stone Identity
    private String kapan;
    private String lotNo;
    private Long shapeId;
    private BigDecimal weightCt;

    // Grading
    private Long colorId;
    private Long clarityId;
    private Long cutId;
    private Long polishId;
    private Long symmetryId;
    private Long fluorescenceId;
    private Long labId;
    private String certNo;

    // Pricing
    private BigDecimal perCarat;
    private BigDecimal totalCarat;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal brokerage;
    private BigDecimal finalAmount;

    // Sale Details
    private Long paymentStatusId;
    private LocalDate sellDate;
    private LocalDate paymentDoneDate;
    private Long locationId;
    private Long termsId;

    private String partyName;
    private String brokerName;

    // GETTERS & SETTERS

    public String getKapan() {
        return kapan;
    }

    public void setKapan(String kapan) {
        this.kapan = kapan;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public Long getShapeId() {
        return shapeId;
    }

    public void setShapeId(Long shapeId) {
        this.shapeId = shapeId;
    }

    public BigDecimal getWeightCt() {
        return weightCt;
    }

    public void setWeightCt(BigDecimal weightCt) {
        this.weightCt = weightCt;
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

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public BigDecimal getPerCarat() {
        return perCarat;
    }

    public void setPerCarat(BigDecimal perCarat) {
        this.perCarat = perCarat;
    }

    public BigDecimal getTotalCarat() {
        return totalCarat;
    }

    public void setTotalCarat(BigDecimal totalCarat) {
        this.totalCarat = totalCarat;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Long getPaymentStatusId() {
        return paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public LocalDate getPaymentDoneDate() {
        return paymentDoneDate;
    }

    public void setPaymentDoneDate(LocalDate paymentDoneDate) {
        this.paymentDoneDate = paymentDoneDate;
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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }
}