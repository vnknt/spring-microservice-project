package com.ingbootcamp.accountservice.business.abstracts;

import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;
import com.ingbootcamp.servicecommon.contracts.AccountDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountService {
    DataResult<List<AccountDto>> getAll();
    DataResult<AccountDto> get(String id);
    Result save(@RequestBody AccountDto accountDto);
    Result delete (String id);
    Result update(@RequestBody AccountDto accountDto);
}
