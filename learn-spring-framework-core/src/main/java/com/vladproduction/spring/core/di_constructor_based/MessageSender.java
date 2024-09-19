package com.vladproduction.spring.core.di_constructor_based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * MessageSender has two constructors;
 * In this scenario we have to annotate one of the existing constructors;
 * So Spring can create bean we are expecting;
 * */
@Component
public class MessageSender {

    private MessageService messageService;
    private MessageService smsService;

//    @Autowired
    public MessageSender(@Qualifier("emailServiceComp") MessageService messageService){
        this.messageService = messageService;
        System.out.println("constructor based DI #1");
    }

    @Autowired
    public MessageSender(@Qualifier("emailServiceComp")MessageService messageService,
                         @Qualifier("smsServiceComp") MessageService smsService){


        this.messageService = messageService;
        this.smsService = smsService;
        System.out.println("constructor based DI #2");
    }


    public void sendMessage(String message){
        this.messageService.sendMessage(message);
        this.smsService.sendMessage(message);
    }

}
