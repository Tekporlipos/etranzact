package com.etranzact.etranzact.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AccountDTO {
    @NotEmpty(message = "Customer ghanaCard must not be empty")
    private String ghanaCard;
    @NotEmpty(message = "Customer branch must not be empty")
    private String branch;
    private String accountNumber;
    private String accountType;
    private String accountName;
    private Double amount;
    private String key;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
