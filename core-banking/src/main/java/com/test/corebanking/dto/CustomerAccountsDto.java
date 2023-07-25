package com.test.corebanking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountsDto {

    private Long customerId;
    private String name;
    private String surname;
    private List<AccountDto> accounts;
}
