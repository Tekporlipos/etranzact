package com.etranzact.etranzact.services;


import com.etranzact.etranzact.model.CustomerModel;
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
public class Customer implements CustomerImp{

    private CustomerRepository customerRepository;
    private ObjectMapper objectMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customer) {
        CustomerModel customerModel = objectMapper.convertValue(customer, CustomerModel.class);
       return objectMapper.convertValue(customerRepository.save(customerModel),CustomerDTO.class);
    }
    @Override
    public Page<CustomerModel> getCustomers(Pageable pageable) {
      return  customerRepository.findAll(pageable);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customer, UUID customerId) {
        CustomerModel customerData = objectMapper.convertValue(customer, CustomerModel.class);
        CustomerModel customerModel = customerRepository.findById(customerId).orElseThrow();// did not find time to handle it well
        customerData.setId(customerModel.getId());
       return objectMapper.convertValue(customerRepository.save(customerData),CustomerDTO.class);
    }

    @Override
    public void deactivateCustomer(UUID customerId) {

    }

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return objectMapper.convertValue(customerRepository.findById(customerId).orElseThrow(),CustomerDTO.class);// did not find time to handle it well
    }
}
