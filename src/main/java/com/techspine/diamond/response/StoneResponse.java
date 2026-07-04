package com.techspine.diamond.response;

import com.techspine.diamond.entity.Stone;
import com.techspine.diamond.projection.StoneProjection;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StoneResponse {

    private Long id;
    private String kapan;
    private String lotNo;
    private String shape;
    private BigDecimal weightCt;
    private String color;
    private String clarity;
    private String cut;
    private String polish;
    private String symmetry;
    private String fluorescence;
    private String lab;
    private String certNo;
    private BigDecimal perCarat;
    private BigDecimal totalCarat;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal brokerage;
    private BigDecimal finalAmount;
    private String paymentStatus;
    private LocalDate sellDate;
    private LocalDate paymentDoneDate;
    private String location;
    private String terms;
    private String partyName;
    private String brokerName;


    public StoneResponse(Stone p) {

        this.id = p.getId();
        this.kapan = p.getKapan();
        this.lotNo = p.getLotNo();

        this.shape = p.getShape() != null
                ? p.getShape().getShapeName()
                : null;

        this.weightCt = p.getWeightCt();

        this.color = p.getColor() != null
                ? p.getColor().getColor()
                : null;

        this.clarity = p.getClarity() != null
                ? p.getClarity().getClarity()
                : null;

        this.cut = p.getCut() != null
                ? p.getCut().getCut()
                : null;

        this.polish = p.getPolish() != null
                ? p.getPolish().getPolish()
                : null;

        this.symmetry = p.getSymmetry() != null
                ? p.getSymmetry().getSymmetry()
                : null;

        this.fluorescence = p.getFluorescence() != null
                ? p.getFluorescence().getFluorescence()
                : null;

        this.lab = p.getLab() != null
                ? p.getLab().getLabName()
                : null;

        this.certNo = p.getCertNo();

        this.perCarat = p.getPerCarat();
        this.totalCarat = p.getTotalCarat();
        this.rate = p.getRate();
        this.amount = p.getAmount();
        this.brokerage = p.getBrokerage();
        this.finalAmount = p.getFinalAmount();

        this.paymentStatus = p.getPaymentStatus() != null
                ? p.getPaymentStatus().getStatus()
                : null;

        this.sellDate = p.getSellDate();
        this.paymentDoneDate = p.getPaymentDoneDate();

        this.location = p.getLocation() != null
                ? p.getLocation().getLocation()
                : null;

        this.terms = p.getTerms() != null
                ? p.getTerms().getTermsName()
                : null;

        this.partyName = p.getPartyName();
        this.brokerName = p.getBrokerName();
    }
    public StoneResponse(StoneProjection p) {

        this.id = p.getId();
        this.kapan = p.getKapan();
        this.lotNo = p.getLotNo();
        this.shape = p.getShape();
        this.weightCt = p.getWeightCt();

        this.color = p.getColor();
        this.clarity = p.getClarity();
        this.cut = p.getCut();
        this.polish = p.getPolish();
        this.symmetry = p.getSymmetry();
        this.fluorescence = p.getFluorescence();
        this.lab = p.getLab();

        this.certNo = p.getCertNo();

        this.perCarat = p.getPerCarat();
        this.totalCarat = p.getTotalCarat();
        this.rate = p.getRate();
        this.amount = p.getAmount();
        this.brokerage = p.getBrokerage();
        this.finalAmount = p.getFinalAmount();

        this.paymentStatus = p.getPaymentStatus();

        this.sellDate = p.getSellDate();
        this.paymentDoneDate = p.getPaymentDoneDate();

        this.location = p.getLocation();
        this.terms = p.getTerms();

        this.partyName = p.getPartyName();
        this.brokerName = p.getBrokerName();
    }

    public Long getId() { return id; }
    public String getKapan() { return kapan; }
    public String getLotNo() { return lotNo; }
    public String getShape() { return shape; }
    public BigDecimal getWeightCt() { return weightCt; }
    public String getColor() { return color; }
    public String getClarity() { return clarity; }
    public String getCut() { return cut; }
    public String getPolish() { return polish; }
    public String getSymmetry() { return symmetry; }
    public String getFluorescence() { return fluorescence; }
    public String getLab() { return lab; }
    public String getCertNo() { return certNo; }
    public BigDecimal getPerCarat() { return perCarat; }
    public BigDecimal getTotalCarat() { return totalCarat; }
    public BigDecimal getRate() { return rate; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getBrokerage() { return brokerage; }
    public BigDecimal getFinalAmount() { return finalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public LocalDate getSellDate() { return sellDate; }
    public LocalDate getPaymentDoneDate() { return paymentDoneDate; }
    public String getLocation() { return location; }
    public String getTerms() { return terms; }
    public String getPartyName() { return partyName; }
    public String getBrokerName() { return brokerName; }
}