package com.test.corebanking.service.impl;

import com.test.corebanking.config.AppConstants;
import com.test.corebanking.dto.CreateCustomerRequest;
import com.test.corebanking.dto.CustomerAccountsDto;
import com.test.corebanking.dto.CustomerDto;
import com.test.corebanking.exception.CustomerNotFoundException;
import com.test.corebanking.model.Customer;
import com.test.corebanking.repository.CustomerRepository;
import com.test.corebanking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .toList();

        return customerDtoList;
    }

    @Override
    public Customer getCustomer(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if(customerOpt.isPresent()) return customerOpt.get();
        else throw new CustomerNotFoundException(AppConstants.CUSTOMER_NOT_FOUND_EXCEPTION);
    }

    @Override
    public List<CustomerAccountsDto> getCustomersAccountsInfo() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerAccountsDto> customerAccountsList = customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerAccountsDto.class))
                .toList();

        return customerAccountsList;
    }

    @Override
    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer newCustomer = Customer.builder()
                .name(createCustomerRequest.getName())
                .surname(createCustomerRequest.getSurname()).build();
        customerRepository.save(newCustomer);
    }
}