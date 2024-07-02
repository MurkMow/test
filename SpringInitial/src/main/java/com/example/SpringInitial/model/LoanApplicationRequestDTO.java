package com.example.SpringInitial.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanApplicationRequestDTO {
    private BigDecimal amount;
    private int term;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private LocalDate birthdate;
    private String passportSeries;
    private String passportNumber;

    public LoanApplicationRequestDTO(BigDecimal amount, int term, String firstName, String lastName, String middleName, String email, LocalDate birthdate, String passportNumber, String passportSeries) {
        this.amount = amount;
        this.term = term;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.birthdate = birthdate;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getTerm() {
        return term;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
