package com.vladproduction.componentannotation;

import com.vladproduction.componentannotation.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComponentAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(ComponentAnnotationApplication.class, args);

//        PizzaController pizzaController = context.getBean(PizzaController.class); // class bean
//        PizzaController pizzaController = (PizzaController) context.getBean("pizzaController"); // class default name bean
        PizzaController pizzaController = (PizzaController) context.getBean("pizza"); // class custom name bean
        String pizza = pizzaController.getPizza();
        System.out.println(pizza);
    }

}
