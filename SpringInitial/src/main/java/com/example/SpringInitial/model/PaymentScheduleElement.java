package com.example.SpringInitial.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentScheduleElement {
    private int number;
    private LocalDate date;
    private BigDecimal totalPayment;
    private BigDecimal interestPayment;
    private BigDecimal debtPayment;
    private BigDecimal remainingDebt;

    public PaymentScheduleElement(int number, LocalDate date, BigDecimal totalPayment, BigDecimal interestPayment, BigDecimal debtPayment, BigDecimal remainingDebt) {
        this.number = number;
        this.date = date;
        this.totalPayment = totalPayment;
        this.interestPayment = interestPayment;
        this.debtPayment = debtPayment;
        this.remainingDebt = remainingDebt;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setInterestPayment(BigDecimal interestPayment) {
        this.interestPayment = interestPayment;
    }

    public void setRemainingDebt(BigDecimal remainingDebt) {
        this.remainingDebt = remainingDebt;
    }

    public void setDebtPayment(BigDecimal debtPayment) {
        this.debtPayment = debtPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public BigDecimal getInterestPayment() {
        return interestPayment;
    }

    public BigDecimal getDebtPayment() {
        return debtPayment;
    }

    public BigDecimal getRemainingDebt() {
        return remainingDebt;
    }
}
