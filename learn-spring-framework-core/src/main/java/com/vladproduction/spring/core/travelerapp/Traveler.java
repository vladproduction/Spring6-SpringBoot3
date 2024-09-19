package com.vladproduction.spring.core.travelerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("traveler")
public class Traveler {

    //instead of injecting object class, we create reference of interface;
//    Car car = null;
//    Bike bike;

    private Vehicle vehicle;


    public Traveler() {
//        this.car = new Car();
//        this.bike = new Bike();
    }

    // 1) basic scenario: @Qualifier
    /**
     * as @qualifier ("?") we can define any: -bike; -cycle; -car;
     * */
    /*@Autowired
    public Traveler(@Qualifier("cycle") Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/

    // 2) Primary qualifier annotation
    /**
     * @Primary annotation for Car is defined;
     * -so no confusion, by default Beans for Car will create;
     * -as a primary annotation, bean has higher preferences;
     * -we can define any as a @Primary annotation: -bike; -cycle; -car;
     * */
    @Autowired
    public Traveler(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney(){
//        this.car.move();
//        this.bike.move();
        this.vehicle.move(); //so car is moving
    }
}
