package com.vladproduction.springboottransactionsecommerce.exception;

public class PaymentException extends RuntimeException{

    public PaymentException(String message) {
        super(message);
    }
}
