package com.techspine.diamond.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface StoneProjection {

    Long getId();

    String getKapan();

    String getLotNo();

    String getShape();

    BigDecimal getWeightCt();

    String getColor();

    String getClarity();

    String getCut();

    String getPolish();

    String getSymmetry();

    String getFluorescence();

    String getLab();

    String getCertNo();

    BigDecimal getPerCarat();

    BigDecimal getTotalCarat();

    BigDecimal getRate();

    BigDecimal getAmount();

    BigDecimal getBrokerage();

    BigDecimal getFinalAmount();

    String getPaymentStatus();

    LocalDate getSellDate();

    LocalDate getPaymentDoneDate();

    String getLocation();

    String getTerms();

    String getPartyName();

    String getBrokerName();
}