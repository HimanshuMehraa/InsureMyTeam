package com.insurance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.*;

@Entity @Getter @Setter @NoArgsConstructor
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Policy number is required")
    @Size(max = 50, message = "Policy number cannot exceed 50 characters")
    private String policyNumber;

    @NotNull(message = "Coverage amount is required")
    @DecimalMin(value = "0.01", message = "Coverage amount must be greater than 0")
    private BigDecimal coverageAmount;

    @NotNull(message = "Premium is required")
    @DecimalMin(value = "0.01", message = "Premium must be greater than 0")
    private BigDecimal premium;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    private Date startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public InsurancePolicy(String policyNumber, BigDecimal coverageAmount,
                           BigDecimal premium, Date startDate,
                           Date endDate, Client client) {
        this.policyNumber = policyNumber;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }
}
