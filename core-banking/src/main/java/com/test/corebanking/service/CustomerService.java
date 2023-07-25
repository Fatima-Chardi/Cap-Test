package com.test.corebanking.service;

import com.test.corebanking.dto.CreateCustomerRequest;
import com.test.corebanking.dto.CustomerAccountsDto;
import com.test.corebanking.dto.CustomerDto;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    Customer getCustomer(Long id) throws CustomerNotFoundException;

    List<CustomerAccountsDto> getCustomersAccountsInfo();

    void createCustomer(CreateCustomerRequest createCustomerRequest);
}
