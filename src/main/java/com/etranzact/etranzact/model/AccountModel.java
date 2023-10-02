package com.etranzact.etranzact.model;

import com.etranzact.etranzact.services.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true,nullable = false)
    private String ghanaCard;
    private String branch;
    @Column(unique = true,nullable = false)
    private String accountNumber;
    private String accountType;
    private String accountName;
    private Double amount;
    private String key;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
