package com.test.corebanking.service.impl;

import com.test.corebanking.dto.CustomerDto;
import com.test.corebanking.model.Customer;
import com.test.corebanking.repository.CustomerRepository;
import com.test.corebanking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
