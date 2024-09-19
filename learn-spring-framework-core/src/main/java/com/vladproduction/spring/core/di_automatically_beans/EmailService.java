package com.vladproduction.spring.core.di_automatically_beans;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
