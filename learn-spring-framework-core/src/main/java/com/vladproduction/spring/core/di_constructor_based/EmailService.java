package com.vladproduction.spring.core.di_constructor_based;

import org.springframework.stereotype.Component;

@Component("emailServiceComp")
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
