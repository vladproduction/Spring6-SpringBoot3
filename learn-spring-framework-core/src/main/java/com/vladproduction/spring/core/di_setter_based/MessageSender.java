package com.vladproduction.spring.core.di_setter_based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * MessageSender has two setters;
 * In this scenario we have to annotate @Autowired both setter methods;
 * So Spring can create bean;
 * */
@Component
public class MessageSender {

    private MessageService messageService;

    private MessageService smsService;


    @Autowired
    public void setMessageService(@Qualifier("emailServiceCompon") MessageService messageService) {
        this.messageService = messageService;
        System.out.println("Setter based DI #1 emailServiceCompon");
    }

    @Autowired
    public void setSmsService(@Qualifier("smsServiceCompon")MessageService smsService) {
        this.smsService = smsService;
        System.out.println("Setter based DI #2 smsServiceCompon");
    }

    public void sendMessage(String message){
        this.messageService.sendMessage(message);
        this.smsService.sendMessage(message);
    }

}
