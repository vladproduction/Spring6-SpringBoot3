package com.vladproduction.spring.core.di_automatically_beans;

import org.springframework.stereotype.Component;

@Component
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
