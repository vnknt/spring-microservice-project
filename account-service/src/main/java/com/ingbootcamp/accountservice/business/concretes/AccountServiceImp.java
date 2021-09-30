package com.ingbootcamp.accountservice.business.concretes;

import com.ingbootcamp.accountservice.business.abstracts.AccountService;
import com.ingbootcamp.servicecommon.contracts.AccountDto;
import com.ingbootcamp.accountservice.dto.AccountConverter;
import com.ingbootcamp.accountservice.entity.Account;
import com.ingbootcamp.accountservice.repository.AccountRepository;
import com.ingbootcamp.servicecommon.results.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImp  implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    private final AccountConverter accountConverter;

    @Override
    public DataResult<List<AccountDto>> getAll() {
        List<Account> accounts = this.accountRepository.findAll();
        List<AccountDto> accountDtos = accountConverter.accountsToAccountDtos(accounts);
        return new SuccessDataResult<List<AccountDto>>(
            accountDtos
        );
    }

    @Override
    public DataResult<AccountDto> get(String id) {
        Account account = accountRepository.findById(id).orElseGet(()->null);
        if(account == null){
            return new ErrorDataResult<>("Account couln't be found");
        }
        return new SuccessDataResult<>(modelMapper.map(account,AccountDto.class));
    }

    @Override
    public Result save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto,Account.class);

        try{
            this.accountRepository.save(account);

        }catch (Exception e){
            return new ErrorResult("An error occured while saving account");
        }
        return new SuccessResult("Account is added successfully");
    }

    @Override
    public Result delete(String id) {
        try{
            accountRepository.deleteById(id);
        }catch (Exception e){
            return new ErrorResult("Error while deleting account");
        }
        return new SuccessResult();
    }

    @Override
    public Result update(AccountDto accountDto) {
        try{
            Account account =modelMapper.map(accountDto,Account.class);
            accountRepository.save(account);
        }catch (Exception e){
            return new ErrorResult("Error while updating");
        }
        return new SuccessResult("Updated Successfully");
    }
}
