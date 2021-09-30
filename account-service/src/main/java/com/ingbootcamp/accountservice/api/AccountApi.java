package com.ingbootcamp.accountservice.api;

import com.ingbootcamp.accountservice.business.abstracts.AccountService;

import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.servicecommon.results.DataResult;
import com.ingbootcamp.servicecommon.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountApi {
    private AccountService accountService;

    @Autowired
    public AccountApi(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<AccountDto>>> getAll(){
        DataResult<List<AccountDto>> result = this.accountService.getAll();
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DataResult<AccountDto>> get(@PathVariable String id){
        DataResult<AccountDto> result = accountService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody AccountDto accountDto){
        Result addResult = accountService.save(accountDto);
        return ResponseEntity.ok(addResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable(value = "id") String id){
        Result deleteResult = accountService.delete(id);
        return ResponseEntity.ok(deleteResult);
    }

    @PutMapping
    public ResponseEntity<Result> update(@RequestBody AccountDto accountDto){
        Result updateResult = accountService.update(accountDto);
        return ResponseEntity.ok(updateResult);
    }



}
