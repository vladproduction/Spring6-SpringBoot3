package com.vladproduction.stereotypeannotation.config;

import com.vladproduction.stereotypeannotation.controller.PizzaController;
import com.vladproduction.stereotypeannotation.service.NonVegPizza;
import com.vladproduction.stereotypeannotation.service.Pizza;
import com.vladproduction.stereotypeannotation.service.VegPizza;
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
