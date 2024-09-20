package com.vladproduction.primaryannotation;

import com.vladproduction.primaryannotation.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimaryAnnotationApplication {

    public static void main(String[] args) {


        var context = SpringApplication.run(PrimaryAnnotationApplication.class, args);
        PizzaController pizzaController = context.getBean(PizzaController.class);
        String pizza = pizzaController.getPizza();
        System.out.println(pizza);
    }

}
