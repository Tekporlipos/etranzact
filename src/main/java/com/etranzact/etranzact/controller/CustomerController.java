package com.etranzact.etranzact.controller;

import com.etranzact.etranzact.model.CustomerModel;
import com.etranzact.etranzact.model.dto.CustomerDTO;
import com.etranzact.etranzact.services.Customer;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@AllArgsConstructor
public class CustomerController {
    private Customer customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }
    @GetMapping
    public ResponseEntity<Page<CustomerModel>> getCustomers(Pageable pageable){
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@Valid @RequestBody CustomerDTO customer, @PathVariable UUID customerId){
        return ResponseEntity.ok(customerService.updateCustomer(customer,customerId));
    }

    @DeleteMapping("/{customerId}")
    public void deactivateCustomer(@PathVariable UUID customerId){
        return;
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
