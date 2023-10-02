package com.etranzact.etranzact.controller;

import com.etranzact.etranzact.model.dto.AccountDTO;
import com.etranzact.etranzact.model.dto.CustomerDTO;
import com.etranzact.etranzact.services.Account;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@CrossOrigin
@AllArgsConstructor
public class AccountController {

    private Account accountService;

    @PutMapping("/{accountId}")
    public ResponseEntity<CustomerDTO> updateAccount(@Valid @RequestBody AccountDTO account, @PathVariable UUID accountId){

        return ResponseEntity.ok(accountService.updateAccount(account,accountId));
    }

}
