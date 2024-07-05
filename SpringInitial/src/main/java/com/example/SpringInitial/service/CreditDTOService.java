package com.example.SpringInitial.service;

import com.example.SpringInitial.model.CreditDTO;
import com.example.SpringInitial.model.EmploymentDTO;
import com.example.SpringInitial.model.PaymentScheduleElement;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditDTOService {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public CreditDTO creditDTO(BigDecimal amount, int term, String firstName, String lastName, String middleName, Enum gender, LocalDate birthdate, String passportNumber, String passportSeries, LocalDate passportIssueDate, String passportIssueBranch, Enum maritalStatus, int dependentAmount, EmploymentDTO employment, String account, boolean isInsuranceEnabled, boolean isSalaryClient) {
        CreditDTO credit = new CreditDTO();
        credit.setInsuranceEnabled(false);
        BigDecimal baseRate = applicationContext.getEnvironment().getProperty("loan.baseRate", BigDecimal.class);
        BigDecimal twenSalary = employment.getSalary().divide(new BigDecimal(20));
        String employmentStatus = employment.getEmploymentStatus().toString();
        String positionStatus = employment.getPosition().toString();
        LocalDate todayDate = LocalDate.now();
        int date = Period.between(birthdate, todayDate).getYears();
        if (validStatus(employmentStatus) && employmentStatus.equals("Безработный")
                || amount.compareTo(twenSalary) > 0
                || (date < 20 || date > 60)
                || employment.getWorkExperienceTotal() < 12) {
            return credit;
        } else
        {
            if (employment.getEmploymentStatus()==EmploymentStatus.Самозанятый) {
                baseRate = baseRate.add(new BigDecimal(1));
                credit.setInsuranceEnabled(true);
            } else {
                baseRate = baseRate.add(new BigDecimal(3));
                credit.setInsuranceEnabled(true);
            }
            if (positionStatus.equals("Менеджер среднего звена")) {
                baseRate = baseRate.subtract(new BigDecimal(2));
            } else {
                baseRate = baseRate.subtract(new BigDecimal(4));
            }
            if (maritalStatus==marital.Замужем|| maritalStatus==marital.Женат) {
                baseRate = baseRate.subtract(new BigDecimal(3));
            } else {
                credit.setInsuranceEnabled(true);
                baseRate = baseRate.add(new BigDecimal(1));
            }
            if (gender == Gender.Женщина && date >= 35 && date <= 60) {
                credit.setSalaryClient(true);
                baseRate = baseRate.subtract(new BigDecimal(3));
            } else if (gender == Gender.Мужчина && date >= 30 && date <= 55) {
                baseRate = baseRate.subtract(new BigDecimal(3));
            } else {
                credit.setInsuranceEnabled(true);
                baseRate = baseRate.add(new BigDecimal(3));
            }
        }

        BigDecimal base = new BigDecimal("12").add(BigDecimal.ONE);
        BigDecimal log = BigDecimal.ONE.subtract(BigDecimal.ONE.divide(base.pow(term), 20, BigDecimal.ROUND_HALF_UP));
        BigDecimal payment = amount.multiply(baseRate).divide(log, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal totalAmount = payment.multiply(new BigDecimal(term).multiply(baseRate));


        credit.setAmount(amount);
        credit.setTerm(term);
        credit.setMonthlyPayment(payment);
        credit.setRate(baseRate);
        credit.setPsk(totalAmount);
        credit.setPaymentSchedule(Calculation(term,baseRate,totalAmount,todayDate,payment));

        return credit;
    }

    public List<PaymentScheduleElement> Calculation (int month, BigDecimal rate, BigDecimal amount, LocalDate startDate, BigDecimal payment){
        List<PaymentScheduleElement> credit = new ArrayList<>();
        BigDecimal monthlyRate = rate.divide(BigDecimal.valueOf(12));
        for (int i=1;i<month;i++){
            LocalDate paymentDate=startDate.plusMonths(i);
            amount.divide(payment);
            startDate.plusMonths(1);
            BigDecimal interestPayment = amount.multiply(monthlyRate).setScale(2);
            BigDecimal debtPayment = payment.subtract(interestPayment).setScale(2);

            PaymentScheduleElement element = new PaymentScheduleElement();
            element.setNumber(i);
            element.setTotalPayment(payment);
            element.setRemainingDebt(amount);
            element.setDate(paymentDate);
            element.setInterestPayment(interestPayment);
            element.setDebtPayment(debtPayment);

            credit.add(element);
        }



        return credit;
    }

    public enum marital{
        Замужем,
        Женат
    }
    public enum Gender{
        Женщина,
        Мужчина
    }

    public enum EmploymentStatus {
        Безработный,
        Самозанятый,
        Владелецбизнеса
    }

    public static boolean validStatus(String status) {
        try {
            EmploymentStatus.valueOf(status);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
