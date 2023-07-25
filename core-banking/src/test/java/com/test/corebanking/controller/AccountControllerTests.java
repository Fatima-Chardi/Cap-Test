package com.test.corebanking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.corebanking.dto.CreateAccountRequest;
import com.test.corebanking.repository.AccountRepository;
import com.test.corebanking.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateAccount() throws Exception{
        CreateAccountRequest accountRequest = getAccountRequest();
        String productRequestString = objectMapper.writeValueAsString(accountRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestString))
                .andExpect(status().isCreated());

        assertEquals(1, accountRepository.findAll().size());
        assertEquals(1, transactionRepository.findAll().size());


    }

    private CreateAccountRequest getAccountRequest() {
        return CreateAccountRequest.builder()
                .customerId(1L)
                .initialCredit(100)
                .build();
    }



}
