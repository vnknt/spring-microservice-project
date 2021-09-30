package com.ingbootcamp.accountservice.dto;

import com.ingbootcamp.accountservice.entity.Account;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountConverter {


    private final ModelMapper modelMapper;

    public  List<AccountDto> accountsToAccountDtos(List<Account> accounts){
        TypeToken<List<AccountDto>> accountDtoType = new TypeToken<>(){};
        return this.modelMapper.map(accounts,accountDtoType.getType());
    }


}
