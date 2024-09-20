package com.vladproduction.bean_and_configurationannotation.config;

import com.vladproduction.bean_and_configurationannotation.controller.PizzaController;
import com.vladproduction.bean_and_configurationannotation.service.NonVegPizza;
import com.vladproduction.bean_and_configurationannotation.service.Pizza;
import com.vladproduction.bean_and_configurationannotation.service.VegPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean(name = "vegPizzaBean")
    @Bean
    public Pizza vegPizza(){
        return new VegPizza();
    }

    @Bean
    public Pizza nonVegPizza(){
        return new NonVegPizza();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public PizzaController pizzaController(){
//        return new PizzaController(vegPizza());
        return new PizzaController(nonVegPizza()); //or nonVegPizza()
    }

}
