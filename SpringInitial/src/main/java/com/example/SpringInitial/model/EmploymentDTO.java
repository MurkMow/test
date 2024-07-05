package com.example.SpringInitial.model;

import java.math.BigDecimal;

public class EmploymentDTO {
    private Enum employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private Enum position;
    private int workExperienceTotal;
    private int workExperienceCurrent;

    public EmploymentDTO() {}

    public void setEmploymentStatus(Enum employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setWorkExperienceCurrent(int workExperienceCurrent) {
        this.workExperienceCurrent = workExperienceCurrent;
    }

    public void setWorkExperienceTotal(int workExperienceTotal) {
        this.workExperienceTotal = workExperienceTotal;
    }

    public void setPosition(Enum position) {
        this.position = position;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setEmployerINN(String employerINN) {
        this.employerINN = employerINN;
    }

    public Enum getEmploymentStatus() {
        return employmentStatus;
    }

    public String getEmployerINN() {
        return employerINN;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Enum getPosition() {
        return position;
    }

    public int getWorkExperienceTotal() {
        return workExperienceTotal;
    }

    public int getWorkExperienceCurrent() {
        return workExperienceCurrent;
    }

    public EmploymentDTO(Enum employmentStatus, int workExperienceCurrent, int workExperienceTotal, Enum position, BigDecimal salary, String employerINN) {
        this.employmentStatus = employmentStatus;
        this.workExperienceCurrent = workExperienceCurrent;
        this.workExperienceTotal = workExperienceTotal;
        this.position = position;
        this.salary = salary;
        this.employerINN = employerINN;
    }
}
