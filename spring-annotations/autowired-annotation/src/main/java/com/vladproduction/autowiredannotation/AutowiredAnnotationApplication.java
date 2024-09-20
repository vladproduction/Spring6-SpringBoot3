package com.vladproduction.autowiredannotation;

import com.vladproduction.autowiredannotation.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutowiredAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(AutowiredAnnotationApplication.class, args);
        PizzaController pizzaController = context.getBean(PizzaController.class);
        String pizza = pizzaController.getPizza();
        System.out.println(pizza);
    }

}
