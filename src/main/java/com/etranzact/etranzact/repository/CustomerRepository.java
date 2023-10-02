package com.etranzact.etranzact.repository;

import com.etranzact.etranzact.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerModel,UUID> , PagingAndSortingRepository<CustomerModel, UUID> {
}
