package com.ingbootcamp.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Date created_at;
}
