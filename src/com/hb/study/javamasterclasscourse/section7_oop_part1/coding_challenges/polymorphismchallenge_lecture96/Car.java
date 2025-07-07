package com.hb.study.javamasterclasscourse.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(int cylinders, String name) {
        System.out.println("Inside Car() constructor; This car is manufactured with " +
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
        System.out.println("startEngine() inside Car class invoked");
    }
    public void accelerate() {
        System.out.println("accelerate() inside Car class invoked");
    }
    public void brake(){
        System.out.println("brake() inside Car class invoked");
    }
}