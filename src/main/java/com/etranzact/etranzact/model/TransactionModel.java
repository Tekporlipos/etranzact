package com.etranzact.etranzact.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionId;
    @Column(nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false)
    private Double amount;
    @Enumerated
    private TransactionType transactionType;
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
