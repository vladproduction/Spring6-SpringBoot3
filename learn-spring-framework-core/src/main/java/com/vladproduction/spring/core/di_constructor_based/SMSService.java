package com.vladproduction.spring.core.di_constructor_based;

import org.springframework.stereotype.Component;

@Component("smsServiceComp")
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
