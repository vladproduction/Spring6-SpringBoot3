package com.vladproduction.spring.core.di_setter_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

        String messageSms = "Hello! This is first message as SMS!";
        String messageEmail = "Hello! This is first message as Email!";

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage(messageEmail);



    }

}
