package com.example.SpringInitial.service;

import com.example.SpringInitial.model.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeService {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }
    public static List<LoanOfferDTO> getOffer(BigDecimal amount, int term, String firstName, String lastName, String middleName, String email, LocalDate birthdate, String passportNumber, String passportSeries) {
        List<LoanOfferDTO> list = new ArrayList<>();
        if (!firstName.matches("^[a-zA-Z]{2,30}$")
                || !middleName.matches("^[a-zA-Z]{2,30}$")
                || !ValidNumber(amount) || term < 6 || !ValidBirthdate(birthdate)
                || !email.matches("[\\w\\.]{2,50}@[\\w\\.]{2,20}")
                || passportNumber.length() != 6
                || passportSeries.length() != 4) {
            return list;
        } else {
            return getList(amount, term);
        }
    }

    public static List<LoanOfferDTO> getList(BigDecimal amount, int term) {
        List<LoanOfferDTO> priceList = new ArrayList<>();
        BigDecimal baseRate = applicationContext.getEnvironment().getProperty("loan.baseRate", BigDecimal.class);
        BigDecimal baseDiscount = applicationContext.getEnvironment().getProperty("loan.baseDiscount", BigDecimal.class);
        BigDecimal r = baseRate.subtract(baseDiscount);
        BigDecimal base = new BigDecimal("12").add(BigDecimal.ONE);
        BigDecimal log = BigDecimal.ONE.subtract(BigDecimal.ONE.divide(base.pow(term), 20, BigDecimal.ROUND_HALF_UP));

        for (boolean lower : new boolean[]{false, true}) {
            for (boolean upper : new boolean[]{false, true}) {
                BigDecimal rate = r;
                if (lower) {
                    rate = rate.subtract(baseDiscount);
                }
                if (upper) {
                    rate = rate.subtract(baseDiscount);
                }
                BigDecimal payment = amount.multiply(r).divide(log, 2, BigDecimal.ROUND_HALF_UP);
                BigDecimal totalAmount = payment.multiply(new BigDecimal(term).multiply(r));

                LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
                loanOfferDTO.setRequestedAmount(amount);
                loanOfferDTO.setRate(rate);
                loanOfferDTO.setInsuranceEnabled(lower);
                loanOfferDTO.setSalaryClient(upper);
                loanOfferDTO.setMonthlyPayment(payment);
                loanOfferDTO.setTerm(term);
                loanOfferDTO.setTotalAmount(totalAmount);

                priceList.add(loanOfferDTO);
            }
        }

        return priceList;
    }

    public static boolean ValidNumber(BigDecimal number) {
        return number != null && number.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean ValidBirthdate(LocalDate birthdate) {
        try {
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthdate, currentDate);
            return !birthdate.isAfter(currentDate) && age.getYears() >= 18;
        } catch (Exception e) {
            return false;
        }
    }
}
