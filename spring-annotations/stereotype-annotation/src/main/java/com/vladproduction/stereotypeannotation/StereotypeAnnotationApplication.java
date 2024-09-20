package com.vladproduction.stereotypeannotation;

import com.vladproduction.stereotypeannotation.controller.MyController;
import com.vladproduction.stereotypeannotation.controller.PizzaController;
import com.vladproduction.stereotypeannotation.repository.MyRepository;
import com.vladproduction.stereotypeannotation.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StereotypeAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(StereotypeAnnotationApplication.class, args);
//        PizzaController pizzaController = context.getBean(PizzaController.class);
//        System.out.println(pizzaController.getPizza());

        MyController myController = context.getBean(MyController.class);
        System.out.println(myController.hello());

        MyService myService = context.getBean(MyService.class);
        System.out.println(myService.hello());

        MyRepository myRepository = context.getBean(MyRepository.class);
        System.out.println(myRepository.hello());
    }

}
