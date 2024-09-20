package com.vladproduction.componentannotation.controller;

import org.springframework.stereotype.Component;

//@Component
@Component("pizza")
public class PizzaController {

    public String getPizza(){
        return "Ordinary Pizza!";
    }

}
