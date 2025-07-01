package com.hb.study.udemy.lpa.section7_oop_part1.coding_challenges.oopsbasicschallenge;

class Car extends Vehicle{

    private int numberOfGears;
    private int currentlyActivatedGear;
    private int numberOfWheels;
    private int numberOfDoors;
    private boolean isManual;


    public Car(String name, String size, int currentSpeed, int currentDirection, int numberOfWheels, int maxSpeed, int numberOfGears, int currentlyActivatedGear) {
        super(name, size, currentSpeed, currentDirection, maxSpeed);
        this.numberOfGears = numberOfGears;
        this.currentlyActivatedGear = currentlyActivatedGear;
        this.numberOfWheels = numberOfWheels;
        this.numberOfDoors = numberOfDoors;
        this.isManual = isManual;
    }
}
