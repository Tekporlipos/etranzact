package com.etranzact.etranzact.model.dto;

import com.etranzact.etranzact.model.AccountModel;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class CustomerDTO {
    private UUID id;
    @NotEmpty(message = "Customer firstName must not be empty")
    private String firstName;
    @NotEmpty(message = "Customer lastName must not be empty")
    private String lastName;
    private String otherName;
    private String email;
    @NotEmpty(message = "Customer phone must not be empty")
    private String phone;
    @NotEmpty(message = "Customer country must not be empty")
    private String country;
    @NotEmpty(message = "Customer city must not be empty")
    private String city;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AccountModel accountModel;
}
