package com.example.SpringInitial.controller;

import com.example.SpringInitial.model.CreditDTO;
import com.example.SpringInitial.model.LoanApplicationRequestDTO;
import com.example.SpringInitial.model.LoanOfferDTO;
import com.example.SpringInitial.model.ScoringDataDTO;
import com.example.SpringInitial.service.OfficeService;
import com.example.SpringInitial.service.CreditDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class getOffers {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private CreditDTOService creditDTOService;

    @PostMapping("/conveyor/offers")
    public List<LoanOfferDTO> getOffer(@RequestBody LoanApplicationRequestDTO request) {
        return officeService.getOffer(
                request.getAmount(),
                request.getTerm(),
                request.getFirstName(),
                request.getLastName(),
                request.getMiddleName(),
                request.getEmail(),
                request.getBirthdate(),
                request.getPassportNumber(),
                request.getPassportSeries()
        );
    }
        @PostMapping("/conveyor/calculation")
        private CreditDTO creditDTO(@RequestBody ScoringDataDTO scoring){
            return creditDTOService.creditDTO(
                    scoring.getAmount(),
                    scoring.getTerm(),
                    scoring.getFirstName(),
                    scoring.getLastName(),
                    scoring.getMiddleName(),
                    scoring.getGender(),
                    scoring.getBirthdate(),
                    scoring.getPassportNumber(),
                    scoring.getPassportSeries(),
                    scoring.getPassportIssueDate(),
                    scoring.getPassportIssueBranch(),
                    scoring.getMaritalStatus(),
                    scoring.getDependentAmount(),
                    scoring.getEmployment(),
                    scoring.getAccount(),
                    scoring.isInsuranceEnabled(),
                    scoring.isSalaryClient()
            );
        }
    }

