package com.test.corebanking.model;

import com.test.corebanking.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="t_transactions")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private double amount;

    private LocalDateTime date;

    private String description;





}
