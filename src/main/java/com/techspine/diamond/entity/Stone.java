package com.techspine.diamond.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "stones")
public class Stone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "kapan")
    private String kapan;

    @Column(name = "lot_no")
    private String lotNo;

    @ManyToOne
    @JoinColumn(name = "shape_id")
    private ShapeMaster shape;

    @Column(name = "weight_ct")
    private BigDecimal weightCt;

    // Grading
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorMaster color;

    @ManyToOne
    @JoinColumn(name = "clarity_id")
    private ClarityMaster clarity;

    @ManyToOne
    @JoinColumn(name = "cut_id")
    private CutMaster cut;

    @ManyToOne
    @JoinColumn(name = "polish_id")
    private PolishMaster polish;

    @ManyToOne
    @JoinColumn(name = "symmetry_id")
    private SymmetryMaster symmetry;

    @ManyToOne
    @JoinColumn(name = "fluorescence_id")
    private FluorescenceMaster fluorescence;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    private LabMaster lab;

    @Column(name = "cert_no")
    private String certNo;

    // Pricing
    @Column(name = "per_carat")
    private BigDecimal perCarat;

    @Column(name = "total_carat")
    private BigDecimal totalCarat;

    private BigDecimal rate;

    private BigDecimal amount;

    private BigDecimal brokerage;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;

    // Sale Details
    @ManyToOne
    @JoinColumn(name = "payment_status_id")
    private PaymentStatusMaster paymentStatus;

    @Column(name = "sell_date")
    private LocalDate sellDate;

    @Column(name = "payment_done_date")
    private LocalDate paymentDoneDate;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationMaster location;

    @ManyToOne
    @JoinColumn(name = "terms_id")
    private TermsMaster terms;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "broker_name")
    private String brokerName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // ==========================
    // PRE PERSIST / PRE UPDATE
    // ==========================

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ==========================
    // GETTERS AND SETTERS
    // ==========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ShapeMaster getShape() {
        return shape;
    }

    public void setShape(ShapeMaster shape) {
        this.shape = shape;
    }

    public BigDecimal getWeightCt() {
        return weightCt;
    }

    public void setWeightCt(BigDecimal weightCt) {
        this.weightCt = weightCt;
    }

    public ColorMaster getColor() {
        return color;
    }

    public void setColor(ColorMaster color) {
        this.color = color;
    }

    public ClarityMaster getClarity() {
        return clarity;
    }

    public void setClarity(ClarityMaster clarity) {
        this.clarity = clarity;
    }

    public CutMaster getCut() {
        return cut;
    }

    public void setCut(CutMaster cut) {
        this.cut = cut;
    }

    public PolishMaster getPolish() {
        return polish;
    }

    public void setPolish(PolishMaster polish) {
        this.polish = polish;
    }

    public SymmetryMaster getSymmetry() {
        return symmetry;
    }

    public void setSymmetry(SymmetryMaster symmetry) {
        this.symmetry = symmetry;
    }

    public FluorescenceMaster getFluorescence() {
        return fluorescence;
    }

    public void setFluorescence(FluorescenceMaster fluorescence) {
        this.fluorescence = fluorescence;
    }

    public LabMaster getLab() {
        return lab;
    }

    public void setLab(LabMaster lab) {
        this.lab = lab;
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

    public PaymentStatusMaster getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusMaster paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public LocationMaster getLocation() {
        return location;
    }

    public void setLocation(LocationMaster location) {
        this.location = location;
    }

    public TermsMaster getTerms() {
        return terms;
    }

    public void setTerms(TermsMaster terms) {
        this.terms = terms;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}