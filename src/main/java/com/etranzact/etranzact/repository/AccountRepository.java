package com.etranzact.etranzact.repository;

import com.etranzact.etranzact.model.AccountModel;
import com.etranzact.etranzact.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends CrudRepository<AccountModel,UUID> , PagingAndSortingRepository<AccountModel, UUID> {

    Optional<AccountModel> findByAccountNumber(String uuid);
}
