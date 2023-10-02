package com.etranzact.etranzact.services;

import com.etranzact.etranzact.model.dto.AccountDTO;
import com.etranzact.etranzact.model.dto.CustomerDTO;

import java.util.UUID;

public interface AccountImp {
    public CustomerDTO updateAccount(AccountDTO account, UUID customerId);
}
