package com.ingbootcamp.accountservice.business.abstracts;

import com.ingbootcamp.accountservice.core.results.DataResult;
import com.ingbootcamp.accountservice.core.results.Result;
import com.ingbootcamp.accountservice.dto.AccountDto;
import com.ingbootcamp.accountservice.entity.Account;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountService {
    DataResult<List<AccountDto>> getAll();
    DataResult<AccountDto> get(String id);
    Result save(@RequestBody AccountDto accountDto);
    Result delete (String id);
    Result update(@RequestBody AccountDto accountDto);
}
