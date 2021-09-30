package com.ingbootcamp.servicecommon.contracts;

import lombok.Data;

@Data
public class AccountDto {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
}
