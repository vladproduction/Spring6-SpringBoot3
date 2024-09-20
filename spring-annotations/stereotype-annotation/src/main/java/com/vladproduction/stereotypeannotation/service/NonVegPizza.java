package com.vladproduction.stereotypeannotation.service;

public class NonVegPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Non-Veg Pizza!";
    }
}
