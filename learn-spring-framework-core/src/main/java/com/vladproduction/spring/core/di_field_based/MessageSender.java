package com.vladproduction.spring.core.di_field_based;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * MessageSender has two fields;
 * In this scenario we have to annotate @Autowired both fields that wanted to be injected;
 * So Spring can create bean in container;
 *
 * -by field-based approach no needed constructor or setters;
 * -spring container uses reflection to create beans in that case;
 * -not available to use immutable fields of that scenario injection; (only by constructor)
 * -classes have tight coupling with Spring IoC container and can not be used outside of it;
 * -classes can not be instantiated without reflection; so, Spring IoC container have to instantiate them and make tests as integrated;
 * -too many dependencies is a red flag to violate Singleton principle (class does more than one thing);
 * */
@Component
public class MessageSender {

    @Autowired
    @Qualifier("emailServiceComponent")
    private MessageService messageService;

    @Autowired
    @Qualifier("smsServiceComponent")
    private MessageService smsService;


    public void sendMessage(String message){
        this.messageService.sendMessage(message);
        this.smsService.sendMessage(message);
    }

}
