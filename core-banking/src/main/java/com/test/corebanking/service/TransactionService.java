package com.test.corebanking.service;

import com.test.corebanking.dto.TransactionDto;
import com.test.corebanking.enums.TransactionType;
import com.test.corebanking.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    void createTransaction(Account account, TransactionType type, double amount, String description);
    List<TransactionDto> getTransactions(Long accountId);
}
