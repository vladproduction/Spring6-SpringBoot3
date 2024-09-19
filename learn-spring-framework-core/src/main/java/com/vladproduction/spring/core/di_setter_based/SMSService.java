package com.vladproduction.spring.core.di_setter_based;

import org.springframework.stereotype.Component;

@Component("smsServiceCompon")
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message){

        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
