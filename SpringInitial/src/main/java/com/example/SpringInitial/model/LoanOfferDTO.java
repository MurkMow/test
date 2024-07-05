package com.example.SpringInitial.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class LoanOfferDTO {
    @Id
    private long applicationID;
    private BigDecimal requestedAmount;
    private BigDecimal totalAmount;
    private int term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;

    public LoanOfferDTO() {
    }

    public LoanOfferDTO(long applicationID, BigDecimal requestedAmount, BigDecimal totalAmount, int term, BigDecimal monthlyPayment, BigDecimal rate, Boolean isInsuranceEnabled, Boolean isSalaryClient) {
        this.applicationID = applicationID;
        this.requestedAmount = requestedAmount;
        this.totalAmount = totalAmount;
        this.term = term;
        this.monthlyPayment = monthlyPayment;
        this.rate = rate;
        this.isInsuranceEnabled = isInsuranceEnabled;
        this.isSalaryClient = isSalaryClient;
    }

    public void setApplicationID(long applicationID) {
        this.applicationID = applicationID;
    }

    public void setSalaryClient(Boolean salaryClient) {
        isSalaryClient = salaryClient;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setInsuranceEnabled(Boolean insuranceEnabled) {
        isInsuranceEnabled = insuranceEnabled;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public long getApplicationID() {
        return applicationID;
    }

    public Boolean getSalaryClient() {
        return isSalaryClient;
    }

    public Boolean getInsuranceEnabled() {
        return isInsuranceEnabled;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getTerm() {
        return term;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }
}
