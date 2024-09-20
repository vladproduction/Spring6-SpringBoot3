package com.vladproduction.qualifierannotation;

import com.vladproduction.qualifierannotation.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QualifierAnnotationApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(QualifierAnnotationApplication.class, args);
        PizzaController pizzaController = context.getBean(PizzaController.class);
        String pizza = pizzaController.getPizza();
        System.out.println(pizza);
    }

}
