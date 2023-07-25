package com.test.corebanking.service.impl;

import com.test.corebanking.dto.TransactionDto;
import com.test.corebanking.enums.TransactionType;
import com.test.corebanking.model.Account;
import com.test.corebanking.model.Transaction;
import com.test.corebanking.repository.TransactionRepository;
import com.test.corebanking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createTransaction(Account account, TransactionType type, double amount, String description) {
        Transaction transaction = Transaction.builder()
                .account(account)
                .type(type)
                .amount(amount)
                .date(LocalDateTime.now())
                .description(description)
                .build();

        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDto> getTransactions(Long accountId){
        List<Transaction> transactionList = transactionRepository.findByAccount_AccountId(accountId);
        List<TransactionDto> transactionDtoList = transactionList.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class))
                .toList();
        return transactionDtoList;
    }
}