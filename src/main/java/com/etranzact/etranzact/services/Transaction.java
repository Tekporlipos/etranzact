package com.etranzact.etranzact.services;


import com.etranzact.etranzact.model.AccountModel;
import com.etranzact.etranzact.model.CustomerModel;
import com.etranzact.etranzact.model.TransactionModel;
import com.etranzact.etranzact.model.dto.CustomerDTO;
import com.etranzact.etranzact.model.dto.DepositDTO;
import com.etranzact.etranzact.model.dto.TransactionDTO;
import com.etranzact.etranzact.model.dto.WithDrawDTO;
import com.etranzact.etranzact.repository.AccountRepository;
import com.etranzact.etranzact.repository.CustomerRepository;
import com.etranzact.etranzact.repository.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class Transaction implements TransactionImp{

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private ObjectMapper objectMapper;

    @Override
    public TransactionDTO deposit(DepositDTO depositDTO) {
        TransactionModel transactionModel = new TransactionModel();
        AccountModel accountModel = accountRepository.findByAccountNumber(depositDTO.getAccountNumber()).orElseThrow();
        if (depositDTO.getAmount() > 0) {
            accountModel.setAmount(accountModel.getAmount() + depositDTO.getAmount());
            accountRepository.save(accountModel);
        }
        transactionModel.setAmount(depositDTO.getAmount());
        transactionModel.setAccountNumber(depositDTO.getAccountNumber());
        transactionModel.setAccountName(depositDTO.getAccountName());
        return  objectMapper.convertValue(transactionRepository.save(transactionModel),TransactionDTO.class);
    }

    @Override
    public TransactionDTO withdraw(WithDrawDTO withDrawDTO) {
        TransactionModel transactionModel = new TransactionModel();
        AccountModel accountModel = accountRepository.findByAccountNumber(withDrawDTO.getAccountNumber()).orElseThrow();
        if (accountModel.getAmount() - withDrawDTO.getAmount() > 0) {
            accountModel.setAmount(accountModel.getAmount() - withDrawDTO.getAmount());
            accountRepository.save(accountModel);
        }
        transactionModel.setAmount(withDrawDTO.getAmount());
        transactionModel.setAccountNumber(withDrawDTO.getAccountNumber());
        transactionModel.setAccountName(withDrawDTO.getAccountName());
        return  objectMapper.convertValue(transactionRepository.save(transactionModel),TransactionDTO.class);
    }

    @Override
    public Page<TransactionDTO> getTransactions(UUID customerId, Pageable pageable) {
        return null;
    }
}
