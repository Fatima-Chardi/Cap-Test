package com.test.corebanking.service.impl;

import com.test.corebanking.config.AppConstants;
import com.test.corebanking.dto.CreateAccountRequest;
import com.test.corebanking.enums.TransactionType;
import com.test.corebanking.exception.AccountNotFoundException;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.exception.NegativeInitialCreditException;
import com.test.corebanking.model.Account;
import com.test.corebanking.model.Customer;
import com.test.corebanking.repository.AccountRepository;
import com.test.corebanking.repository.CustomerRepository;
import com.test.corebanking.repository.TransactionRepository;
import com.test.corebanking.service.AccountService;
import com.test.corebanking.service.CustomerService;
import com.test.corebanking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountRepository accountRepository;


    @Override
    public void createAccount(CreateAccountRequest createAccountRequest) throws CustomerNotFoundException, NegativeInitialCreditException {
        Customer customer = customerService.getCustomer(createAccountRequest.getCustomerId());
            Account newAccount = Account.builder()
                    .customer(customer)
                    .balance(0)
                    .build();

            Account account = accountRepository.save(newAccount);
            if(createAccountRequest.getInitialCredit()<0){
                throw new NegativeInitialCreditException(AppConstants.NEGATIVE_INITIAL_CREDIT_EXCEPTION);
            }
            else if(createAccountRequest.getInitialCredit()>0){
                transactionService.createTransaction(account, TransactionType.CREDIT, createAccountRequest.getInitialCredit(), AppConstants.INIT_CREDIT_TRANSACTION);
                account.setBalance(createAccountRequest.getInitialCredit());
                accountRepository.save(account);
            }
        }

    @Override
    public Account getAccount(Long id) throws AccountNotFoundException {
        Optional<Account> accountOpt = accountRepository.findById(id);
        if(accountOpt.isPresent()) return accountOpt.get();
        else throw new AccountNotFoundException(AppConstants.ACCOUNT_NOT_FOUND_EXCEPTION);
    }
}
