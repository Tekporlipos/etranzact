package com.etranzact.etranzact.repository;

import com.etranzact.etranzact.model.AccountModel;
import com.etranzact.etranzact.model.TransactionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TransactionRepository extends CrudRepository<TransactionModel,UUID> , PagingAndSortingRepository<TransactionModel, UUID> {

}
