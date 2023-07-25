package com.test.corebanking.controller;

import com.test.corebanking.dto.CreateCustomerRequest;
import com.test.corebanking.dto.CustomerAccountsDto;
import com.test.corebanking.dto.CustomerDto;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.exception.NegativeInitialCreditException;
import com.test.corebanking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) throws CustomerNotFoundException, NegativeInitialCreditException {
        customerService.createCustomer(createCustomerRequest);
    }

    @GetMapping(value = "/accounts-details")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerAccountsDto> getCustomersAccountsDetails(){
        return customerService.getCustomersAccountsInfo();
    }
}
