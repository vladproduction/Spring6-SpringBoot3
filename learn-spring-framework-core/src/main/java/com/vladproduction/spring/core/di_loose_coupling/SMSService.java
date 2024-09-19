package com.vladproduction.spring.core.di_loose_coupling;

public class SMSService implements MessageService{

    @Override
    public void sendMessage(String message){

        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
