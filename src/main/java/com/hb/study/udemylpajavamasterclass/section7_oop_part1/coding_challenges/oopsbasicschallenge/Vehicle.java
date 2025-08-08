package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.oopsbasicschallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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
        ConsoleStyler.styleOutput("Vehicle.move() called....");
    }

    public void stop(){
        ConsoleStyler.styleOutput("Vehicle.stop() called....");
    }

}
