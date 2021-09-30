package com.ingbootcamp.accountservice.dto;

import lombok.Data;

@Data
public class AccountDto {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
}
