package com.hb.study.udemy.lpa.section7_oop_part1.coding_challenges.oopsbasicschallenge;

class Vehicle {
    private String name;
    private String size;
    private int currentVelocity;
    private int currentDirection;
    private int maxSpeed;

    public Vehicle(String name, String size, int currentVelocity, int currentDirection, int maxSpeed) {
        this.name = name;
        this.size = size;
        this.currentVelocity = currentVelocity;
        this.currentDirection = 0;
        this.maxSpeed = maxSpeed;
    }

    public void move(){
        System.out.println("Vehicle.move() called....");
    }

    public void stop(){
        System.out.println("Vehicle.stop() called....");
    }

}
