package com.vladproduction.qualifierannotation.service;

import org.springframework.stereotype.Component;

@Component
public class VegPizza implements Pizza{

    @Override
    public String getPizza(){
        return "Veg Pizza!";
    }

}
