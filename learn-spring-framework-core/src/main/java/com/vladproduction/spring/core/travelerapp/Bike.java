package com.vladproduction.spring.core.travelerapp;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle{

    @Override
    public void move(){
        System.out.println("Bike is moving...");
    }

}
