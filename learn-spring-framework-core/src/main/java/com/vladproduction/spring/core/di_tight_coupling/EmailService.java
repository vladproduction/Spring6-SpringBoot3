package com.vladproduction.spring.core.di_tight_coupling;

public class EmailService {

    public void sendMessage(String message){
        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
