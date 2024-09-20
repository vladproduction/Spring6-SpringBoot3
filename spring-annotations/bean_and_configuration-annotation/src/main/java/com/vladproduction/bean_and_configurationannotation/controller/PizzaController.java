package com.vladproduction.bean_and_configurationannotation.controller;


import com.vladproduction.bean_and_configurationannotation.service.Pizza;

public class PizzaController {

    private Pizza pizza;

    public PizzaController(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getPizza(){
        return pizza.getPizza();
    }

    public void init() {
        System.out.println("init logic");
    }

    public void destroy() {
        System.out.println("destroy logic");
    }
}
