package com.vladproduction.crudannotation.model;

public class Vehicle {

    private Long id;
    private String brand;
    private double price;

    public Vehicle(Long id, String brand, double price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
