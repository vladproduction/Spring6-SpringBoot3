package com.vladproduction.bankingapp.service;

import com.vladproduction.bankingapp.dto.AccountDto;
import com.vladproduction.bankingapp.exception.AccountBalanceInsufficientException;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount) throws AccountBalanceInsufficientException;
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);

}
