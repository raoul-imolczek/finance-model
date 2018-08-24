package com.imolczek.training.finance.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

public class CashFlow {

    private BigDecimal amount;
    private LocalDate date;

    public CashFlow(BigDecimal amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public LocalDate getDate() {
        return this.date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDiscountedValue(LocalDate startDate, double rate) {
        double res;
        res = this.amount.doubleValue() / 
            Math.pow(
                rate + 1, 
                new Double(Duration.between(startDate.atTime(0, 0), this.date.atTime(0, 0)).toDays()) / 365
            );
        return res;
    }

}
