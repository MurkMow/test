package com.example.SpringInitial.model;

import java.math.BigDecimal;

public class EmploymentDTO {
    private Enum employmentStatus;
    private String employerINN;
    private BigDecimal salary;
    private Enum position;
    private int workExperienceTotal;

    public EmploymentDTO(Enum employmentStatus, int workExperienceTotal, Enum position, BigDecimal salary, String employerINN) {
        this.employmentStatus = employmentStatus;
        this.workExperienceTotal = workExperienceTotal;
        this.position = position;
        this.salary = salary;
        this.employerINN = employerINN;
    }

    public void setEmploymentStatus(Enum employmentStatus) {
        this.employmentStatus = employmentStatus;
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

    public int getWorkExperienceTotal() {
        return workExperienceTotal;
    }

    public Enum getPosition() {
        return position;
    }

    public String getEmployerINN() {
        return employerINN;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
