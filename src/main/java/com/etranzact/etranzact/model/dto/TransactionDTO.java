package com.etranzact.etranzact.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TransactionDTO {
    private String branch;
    @NotEmpty(message = "Account accountNumber must not be empty")
    private String accountNumber;
    private String accountName;
    @NotEmpty(message = "Transaction amount must not be empty")
    private Double amount;
}
