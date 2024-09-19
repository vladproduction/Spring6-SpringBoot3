package com.vladproduction.spring.core.di_tight_coupling;

public class MessageSender {

    private SMSService smsService;

    private EmailService emailService;

    public MessageSender(SMSService smsService) {
        this.smsService = smsService;
    }


    public MessageSender(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendMessageSms(String message){
        this.smsService.sendMessage(message);
    }

    public void sendMessageEmail(String message){
        this.emailService.sendMessage(message);
    }
}
