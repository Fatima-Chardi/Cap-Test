package com.test.corebanking.dto;

import com.test.corebanking.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private TransactionType type;
    private double amount;
    private String description;
    private LocalDateTime date;

}
