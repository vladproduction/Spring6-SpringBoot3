package com.vladproduction.spring.core.di_tight_coupling;

public class SMSService {

    public void sendMessage(String message){
        System.out.println("SMSService:sendMessage:message = " + message);
    }

}
