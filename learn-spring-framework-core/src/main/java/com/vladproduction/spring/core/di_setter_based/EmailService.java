package com.vladproduction.spring.core.di_setter_based;

import org.springframework.stereotype.Component;

@Component("emailServiceCompon")
public class EmailService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
