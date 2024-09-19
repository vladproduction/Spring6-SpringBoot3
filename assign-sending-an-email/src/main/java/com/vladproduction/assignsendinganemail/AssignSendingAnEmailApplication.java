package com.vladproduction.assignsendinganemail;

import com.vladproduction.assignsendinganemail.service.SenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignSendingAnEmailApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(AssignSendingAnEmailApplication.class, args);

        SenderService senderServicePrimary = context.getBean(SenderService.class);
        senderServicePrimary.sendEmail();
    }

}
