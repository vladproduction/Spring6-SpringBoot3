package com.vladproduction.spring.core.travelerapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.vladproduction.spring.core.travelerapp")
public class AppTravelConfigure {

    /*@Bean
    public Vehicle car(){
        return new Car();
    }

    @Bean
    public Vehicle bike(){
        return new Bike();
    }

    @Bean
    public Vehicle cycle(){
        return new Cycle();
    }

    @Bean
    public Traveler traveler(){
        return new Traveler(car()); // DI
    }*/

}
