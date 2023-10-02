package com.etranzact.etranzact.controller;

import com.etranzact.etranzact.model.dto.DepositDTO;
import com.etranzact.etranzact.model.dto.TransactionDTO;
import com.etranzact.etranzact.model.dto.WithDrawDTO;
import com.etranzact.etranzact.services.Transaction;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
    private Transaction transactionService;
    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> deposit(@Valid @RequestBody DepositDTO depositDTO){
        return ResponseEntity.ok(transactionService.deposit(depositDTO));
    }
    @PostMapping("withdraw")
    public ResponseEntity<TransactionDTO> withdraw(@Valid @RequestBody WithDrawDTO withDrawDTO){
        return ResponseEntity.ok(transactionService.withdraw(withDrawDTO));
    }
    @PutMapping("/{accountId}")
    public void history(Pageable pageable){
        return;
    }
}
