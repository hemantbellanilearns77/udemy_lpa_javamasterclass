package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

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
        ConsoleStyler.styleOutput("startEngine() inside Car class invoked");
    }
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() inside Car class invoked");
    }
    public void brake(){
        ConsoleStyler.styleOutput("brake() inside Car class invoked");
    }
}