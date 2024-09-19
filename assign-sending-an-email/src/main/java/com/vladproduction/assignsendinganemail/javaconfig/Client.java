package com.vladproduction.assignsendinganemail.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "javaconfigProfile");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SenderService emailService = applicationContext.getBean(EmailService.class);
        emailService.sendEmail();

        String getKeyProperty = applicationContext.getBean("getKeyProperty", String.class);
        System.out.println("getKeyProperty = " + getKeyProperty);

    }
}
