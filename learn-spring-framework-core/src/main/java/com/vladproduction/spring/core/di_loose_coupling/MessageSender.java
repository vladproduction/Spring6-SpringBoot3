package com.vladproduction.spring.core.di_loose_coupling;

public class MessageSender {

    private MessageService messageService;

    public MessageSender(MessageService messageService){
        this.messageService = messageService;
    }

    public void sendMessage(String message){
        this.messageService.sendMessage(message);
    }

}
