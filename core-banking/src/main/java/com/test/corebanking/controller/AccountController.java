package com.test.corebanking.controller;

import com.test.corebanking.dto.CreateAccountRequest;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.exception.NegativeInitialCreditException;
import com.test.corebanking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody CreateAccountRequest createAccountRequest) throws CustomerNotFoundException, NegativeInitialCreditException {
        accountService.createAccount(createAccountRequest);
    }
}
