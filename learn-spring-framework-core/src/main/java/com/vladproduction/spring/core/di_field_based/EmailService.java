package com.vladproduction.spring.core.di_field_based;

import org.springframework.stereotype.Component;

@Component("emailServiceComponent")
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
