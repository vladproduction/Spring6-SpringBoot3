package com.vladproduction.spring.core.di_field_based;

import org.springframework.stereotype.Component;

@Component("smsServiceComponent")
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
