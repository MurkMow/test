package com.example.SpringInitial.model;

import java.math.BigDecimal;
import java.util.List;

public class CreditDTO  {
    private BigDecimal amount;
    private int term;
    private BigDecimal monthlyPayment;
    private BigDecimal rate;
    private BigDecimal psk;
    private boolean isInsuranceEnabled;
    private boolean isSalaryClient;
    private List<PaymentScheduleElement> paymentSchedule;

    public CreditDTO(BigDecimal amount, List<PaymentScheduleElement> paymentSchedule, boolean isSalaryClient, boolean isInsuranceEnabled, BigDecimal psk, BigDecimal rate, BigDecimal monthlyPayment, int term) {
        this.amount = amount;
        this.paymentSchedule = paymentSchedule;
        this.isSalaryClient = isSalaryClient;
        this.isInsuranceEnabled = isInsuranceEnabled;
        this.psk = psk;
        this.rate = rate;
        this.monthlyPayment = monthlyPayment;
        this.term = term;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPaymentSchedule(List<PaymentScheduleElement> paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setSalaryClient(boolean salaryClient) {
        isSalaryClient = salaryClient;
    }

    public void setInsuranceEnabled(boolean insuranceEnabled) {
        isInsuranceEnabled = insuranceEnabled;
    }

    public void setPsk(BigDecimal psk) {
        this.psk = psk;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<PaymentScheduleElement> getPaymentSchedule() {
        return paymentSchedule;
    }

    public boolean isSalaryClient() {
        return isSalaryClient;
    }

    public boolean isInsuranceEnabled() {
        return isInsuranceEnabled;
    }

    public BigDecimal getPsk() {
        return psk;
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
}
