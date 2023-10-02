package com.etranzact.etranzact.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WithDrawDTO extends TransactionDTO{
    private String key;
}
