package com.vladproduction.valueannotation;

import com.vladproduction.valueannotation.controller.MyController;
import com.vladproduction.valueannotation.repository.MyRepository;
import com.vladproduction.valueannotation.service.MyService;
import com.vladproduction.valueannotation.value.ValueAnnotationDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValueAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(ValueAnnotationApplication.class, args);
        MyController myController = context.getBean(MyController.class);
        System.out.println(myController.hello());

        MyService myService = context.getBean(MyService.class);
        System.out.println(myService.hello());

        MyRepository myRepository = context.getBean(MyRepository.class);
        System.out.println(myRepository.hello());

        ValueAnnotationDemo valueAnnotationDemo = context.getBean(ValueAnnotationDemo.class);
        System.out.println(valueAnnotationDemo.getDefaultName());
        System.out.println(valueAnnotationDemo.getHost());
        System.out.println(valueAnnotationDemo.getEmail());
        System.out.println(valueAnnotationDemo.getPassword());
        System.out.println(valueAnnotationDemo.getJavaHome());
        System.out.println(valueAnnotationDemo.getHomeDir());
        System.out.println(valueAnnotationDemo.getServerPort());
    }

}
