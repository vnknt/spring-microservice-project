package com.ingbootcamp.servicecommon.clients;

import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("account-service")
public interface AccountServiceClient  {
    @RequestMapping("/accounts/{id}")
    ResponseEntity<DataResult<AccountDto>> get(@PathVariable(value ="id") String id);
}
