package com.vladproduction.valueannotation.service;

public class NonVegPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Non-Veg Pizza!";
    }
}
