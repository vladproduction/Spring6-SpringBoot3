package com.vladproduction.thymeleafspringboot.model;

public class Avenger {

    private String name;
    private String power;
    private String gender;
    private boolean isAvenger;

    public Avenger(String name, String power, String gender, boolean isAvenger) {
        this.name = name;
        this.power = power;
        this.gender = gender;
        this.isAvenger = isAvenger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAvenger() {
        return isAvenger;
    }

    public void setAvenger(boolean avenger) {
        isAvenger = avenger;
    }
}
