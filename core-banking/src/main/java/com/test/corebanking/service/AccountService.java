package com.test.corebanking.service;

import com.test.corebanking.dto.CreateAccountRequest;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.exception.NegativeInitialCreditException;
import org.springframework.stereotype.Service;


@Service
public interface AccountService {

    void createAccount(CreateAccountRequest createAccountRequest) throws CustomerNotFoundException, NegativeInitialCreditException;
}


