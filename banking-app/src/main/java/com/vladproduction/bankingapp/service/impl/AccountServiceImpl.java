package com.vladproduction.bankingapp.service.impl;

import com.vladproduction.bankingapp.dto.AccountDto;
import com.vladproduction.bankingapp.entity.Account;
import com.vladproduction.bankingapp.exception.AccountBalanceInsufficientException;
import com.vladproduction.bankingapp.mapper.AccountMapper;
import com.vladproduction.bankingapp.repository.AccountRepository;
import com.vladproduction.bankingapp.service.AccountService;
import com.vladproduction.bankingapp.exception.AccountDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) throws AccountBalanceInsufficientException {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));
        if(account.getBalance() < amount){
            throw new AccountBalanceInsufficientException("Account balance is insufficient of funds");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountsDto = accounts.stream().map(AccountMapper::mapToAccountDto).toList();
        return accountsDto;
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
