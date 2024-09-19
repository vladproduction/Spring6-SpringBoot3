package com.vladproduction.spring.core.di_tight_coupling;

public class Client {

    public static void main(String[] args) {

        String messageSms = "Hello! This is first message as SMS!";
        SMSService smsService = new SMSService();
        MessageSender messageSender1 = new MessageSender(smsService);
        messageSender1.sendMessageSms(messageSms);

        String messageEmail = "Hello! This is first message as Email!";
        EmailService emailService = new EmailService();
        MessageSender messageSender2 = new MessageSender(emailService);
        messageSender2.sendMessageEmail(messageEmail);

    }

}
