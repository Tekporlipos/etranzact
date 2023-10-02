package com.etranzact.etranzact.services;


import com.etranzact.etranzact.model.AccountModel;
import com.etranzact.etranzact.model.CustomerModel;
import com.etranzact.etranzact.model.dto.AccountDTO;
import com.etranzact.etranzact.model.dto.CustomerDTO;
import com.etranzact.etranzact.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class Account implements AccountImp{

    private CustomerRepository customerRepository;
    private ObjectMapper objectMapper;
    @Override
    public CustomerDTO updateAccount(AccountDTO accountDTO, UUID customerId) {
        AccountModel accountModel = objectMapper.convertValue(accountDTO, AccountModel.class);
        CustomerModel customerModel = customerRepository.findById(customerId).orElseThrow();// did not find time to handle it well
        customerModel.setAccountModel(accountModel);
        return objectMapper.convertValue(customerRepository.save(customerModel),CustomerDTO.class);
    }
}
