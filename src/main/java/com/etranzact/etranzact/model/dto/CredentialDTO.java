package com.etranzact.etranzact.model.dto;


import lombok.Data;

@Data
public class CredentialDTO {
    private String accountType;
    private String accountName;
    private String key;
}
