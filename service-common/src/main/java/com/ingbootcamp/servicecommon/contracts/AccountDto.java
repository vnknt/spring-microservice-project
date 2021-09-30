package com.ingbootcamp.servicecommon.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
}
