package com.vladproduction.bankingapp.exception;

public class AccountDoesNotExistException extends RuntimeException {


    public AccountDoesNotExistException(String message) {
        super(message);
    }
}
