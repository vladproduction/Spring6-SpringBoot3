package com.vladproduction.spring.core.demoapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoClient {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoAppConfig.class);

        DemoController demoController = applicationContext.getBean(DemoController.class);
        System.out.println("demoController.hello() = " + demoController.hello());

        DemoService demoService = applicationContext.getBean(DemoService.class);
        System.out.println("demoService.hello() = " + demoService.hello());

        DemoRepository demoRepository = applicationContext.getBean(DemoRepository.class);
        System.out.println("demoRepository.hello() = " + demoRepository.hello());


    }

}
