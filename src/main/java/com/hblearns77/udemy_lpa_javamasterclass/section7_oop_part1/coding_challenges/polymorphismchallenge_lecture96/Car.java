package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class Car {
    private static final String INSIDE_CAR_CLASS_INVOKED = "inside Car class invoked";
    private final String name;
    private final boolean engine;
    private final int cylinders;
    private final int wheels;

    public Car(int cylinders, String name) {
        ConsoleStyler.styleOutput("Inside Car() constructor; This car is manufactured with " +
                cylinders + " cylinders " +
                " and is called " + name) ;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.name = name;
    }

    public boolean getEngine() {
        return engine;
    }
    public int getCylinders() {
        return cylinders;
    }
    public int getWheels() {
        return wheels;
    }
    public String getName() {
        return name;
    }
    public void startEngine() {
        ConsoleStyler.styleOutput("startEngine() " + INSIDE_CAR_CLASS_INVOKED);
    }
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() " + INSIDE_CAR_CLASS_INVOKED);
    }
    public void brake(){
        ConsoleStyler.styleOutput("brake() " + INSIDE_CAR_CLASS_INVOKED);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                ", cylinders=" + getCylinders() +
                ", wheels=" + getWheels() +
                '}';
    }
}