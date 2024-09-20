package com.vladproduction.bean_and_configurationannotation;

import com.vladproduction.bean_and_configurationannotation.controller.PizzaController;
import com.vladproduction.bean_and_configurationannotation.service.Pizza;
import com.vladproduction.bean_and_configurationannotation.service.VegPizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanAndConfigurationAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(BeanAndConfigurationAnnotationApplication.class, args);
//        PizzaController pizzaController = context.getBean(PizzaController.class);
//        String pizza = pizzaController.getPizza();
//        System.out.println(pizza);

//        VegPizza vegPizza = context.getBean(VegPizza.class); // class bean
//        VegPizza vegPizza = (VegPizza) context.getBean("vegPizzaBean"); //bean name custom
//        VegPizza vegPizza = (VegPizza) context.getBean("vegPizza"); // bean name default
//        System.out.println(vegPizza.getPizza());

        PizzaController contextBean = context.getBean(PizzaController.class);
        System.out.println(contextBean.getPizza());
    }

}
