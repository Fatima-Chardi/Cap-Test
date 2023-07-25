package com.test.corebanking.controller;

import com.test.corebanking.dto.TransactionDto;
import com.test.corebanking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDto> getTransactions(@RequestParam("accountId") Long accountId){
        return transactionService.getTransactions(accountId);
    }
}
