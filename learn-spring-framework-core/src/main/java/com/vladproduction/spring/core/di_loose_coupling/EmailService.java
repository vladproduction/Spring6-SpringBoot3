package com.vladproduction.spring.core.di_loose_coupling;

public class EmailService implements MessageService{

    @Override
    public void sendMessage(String message){

        System.out.println("EmailService:sendMessage:message = " + message);
    }

}
