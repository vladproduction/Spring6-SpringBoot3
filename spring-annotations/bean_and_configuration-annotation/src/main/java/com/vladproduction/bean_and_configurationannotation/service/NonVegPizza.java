package com.vladproduction.bean_and_configurationannotation.service;

public class NonVegPizza implements Pizza{
    @Override
    public String getPizza() {
        return "Non-Veg Pizza!";
    }
}
