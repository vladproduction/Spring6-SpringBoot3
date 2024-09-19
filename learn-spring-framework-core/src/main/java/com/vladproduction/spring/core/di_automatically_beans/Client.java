package com.vladproduction.spring.core.di_automatically_beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

        String messageSms = "Hello! This is first message as SMS!";
        String messageEmail = "Hello! This is first message as Email!";

        /*MessageService smsService = new SMSService();
        MessageService emailService = new EmailService();

        MessageSender messageSender1 = new MessageSender(smsService);
        MessageSender messageSender2 = new MessageSender(emailService);

        messageSender1.sendMessage(messageSms);
        messageSender2.sendMessage(messageEmail);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage(messageEmail);

    }

}
