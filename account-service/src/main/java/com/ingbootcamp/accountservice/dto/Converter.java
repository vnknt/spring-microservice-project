package com.ingbootcamp.accountservice.dto;

import com.ingbootcamp.accountservice.entity.Account;

public class Converter {
    public static AccountDto AccountToDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setSurname(account.getSurname());
        accountDto.setUsername(account.getUsername());
        return accountDto;
    }

    public static Account DtoToAccount(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        return  account;
    }


}
