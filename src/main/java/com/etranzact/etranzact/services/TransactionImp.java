package com.etranzact.etranzact.services;

import com.etranzact.etranzact.model.dto.DepositDTO;
import com.etranzact.etranzact.model.dto.TransactionDTO;
import com.etranzact.etranzact.model.dto.WithDrawDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TransactionImp {
    public TransactionDTO deposit(DepositDTO depositDTO);
    public TransactionDTO withdraw(WithDrawDTO pageable);
    public Page<TransactionDTO> getTransactions(UUID customerId, Pageable pageable);
}
