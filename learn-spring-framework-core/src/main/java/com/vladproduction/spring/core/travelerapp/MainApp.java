package com.vladproduction.spring.core.travelerapp;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        //need to create instance of car for example and pass it to Traveler as param;
        //making reference to interface but object as car;
        /* Vehicle vehicleCar = new Car();
        Vehicle vehicleBike = new Bike();
        Vehicle vehicleCycle = new Cycle();

        Traveler travelerCar = new Traveler(vehicleCar);
        Traveler travelerBike = new Traveler(vehicleBike);
        Traveler travelerCycle = new Traveler(vehicleCycle);
        travelerCar.startJourney();
        travelerBike.startJourney();
        travelerCycle.startJourney();*/

        /*
        *   Car is moving...
            Bike is moving...
            Cycle is moving...
        * */
        //System.out.println("-------------------");
        //Creating Spring IOC container
        //Read the configuration class
        //Create and manage Spring Beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppTravelConfigure.class);

        //Retrieve Spring Beans from Spring IOC Container
        /* Car car = applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        Cycle cycle = applicationContext.getBean(Cycle.class);
        cycle.move();*/

        Traveler traveler = applicationContext.getBean(Traveler.class);
        traveler.startJourney(); //created bean from Car.class (Car is moving...)
    }
}
