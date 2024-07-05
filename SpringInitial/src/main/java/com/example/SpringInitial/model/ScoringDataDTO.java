package com.example.SpringInitial.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScoringDataDTO {
    private BigDecimal amount;
    private int term;
    private String firstName;
    private String lastName;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Enum gender;
    private LocalDate birthdate;
    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Enum maritalStatus;
    private int dependentAmount;
    private EmploymentDTO employment;
    private String account;
    private boolean isInsuranceEnabled;
    private boolean isSalaryClient;

    public ScoringDataDTO() {

    }

    public ScoringDataDTO(BigDecimal amount, int term, String firstName, String lastName, String middleName, Enum gender, LocalDate birthdate, String passportNumber, String passportSeries, LocalDate passportIssueDate, String passportIssueBranch, Enum maritalStatus, int dependentAmount, EmploymentDTO employment, String account, boolean isInsuranceEnabled, boolean isSalaryClient) {
        this.amount = amount;
        this.term = term;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
        this.passportIssueDate = passportIssueDate;
        this.passportIssueBranch = passportIssueBranch;
        this.maritalStatus = maritalStatus;
        this.dependentAmount = dependentAmount;
        this.employment = employment;
        this.account = account;
        this.isInsuranceEnabled = isInsuranceEnabled;
        this.isSalaryClient = isSalaryClient;
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

    public void setGender(Enum gender) {
        this.gender = gender;
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

    public void setPassportIssueDate(LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public void setPassportIssueBranch(String passportIssueBranch) {
        this.passportIssueBranch = passportIssueBranch;
    }

    public void setMaritalStatus(Enum maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setEmployment(EmploymentDTO employment) {
        this.employment = employment;
    }

    public void setDependentAmount(int dependentAmount) {
        this.dependentAmount = dependentAmount;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setInsuranceEnabled(boolean insuranceEnabled) {
        isInsuranceEnabled = insuranceEnabled;
    }

    public void setSalaryClient(boolean salaryClient) {
        isSalaryClient = salaryClient;
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

    public Enum getGender() {
        return gender;
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

    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }

    public String getPassportIssueBranch() {
        return passportIssueBranch;
    }

    public int getDependentAmount() {
        return dependentAmount;
    }

    public Enum getMaritalStatus() {
        return maritalStatus;
    }

    public EmploymentDTO getEmployment() {
        return employment;
    }

    public String getAccount() {
        return account;
    }

    public boolean isInsuranceEnabled() {
        return isInsuranceEnabled;
    }

    public boolean isSalaryClient() {
        return isSalaryClient;
    }
}
