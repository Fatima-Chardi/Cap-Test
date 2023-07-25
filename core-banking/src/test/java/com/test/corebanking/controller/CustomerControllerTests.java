package com.test.corebanking.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.corebanking.dto.CustomerAccountsDto;
import com.test.corebanking.model.Customer;
import com.test.corebanking.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetCreatedCustomers() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/customer"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();

        List<Customer> response = objectMapper.readValue(contentAsString, new TypeReference<List<Customer>>() {});

        assertEquals(3, response.size());

    }

    @Test
    public void shouldGetCustomersAccountsDetails() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/customer/accounts-details"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();

        List<CustomerAccountsDto> response = objectMapper.readValue(contentAsString, new TypeReference<List<CustomerAccountsDto>>() {});

        assertEquals(1, response.get(0).getAccounts().size());

    }



}
