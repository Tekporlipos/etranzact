package com.etranzact.etranzact.services;

import com.etranzact.etranzact.model.CustomerModel;
import com.etranzact.etranzact.model.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CustomerImp {
    public CustomerDTO createCustomer(CustomerDTO customer);
    public Page<CustomerModel> getCustomers(Pageable pageable);
    public CustomerDTO updateCustomer(CustomerDTO customer, UUID customerId);

    public void deactivateCustomer(UUID customerId);
    public CustomerDTO getCustomerById(UUID customerId);
}
