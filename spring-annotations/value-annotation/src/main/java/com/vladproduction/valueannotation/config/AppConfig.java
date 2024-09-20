package com.vladproduction.valueannotation.config;

import com.vladproduction.valueannotation.controller.PizzaController;
import com.vladproduction.valueannotation.service.NonVegPizza;
import com.vladproduction.valueannotation.service.Pizza;
import com.vladproduction.valueannotation.service.VegPizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

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
        return new PizzaController(vegPizza());
    }

}
