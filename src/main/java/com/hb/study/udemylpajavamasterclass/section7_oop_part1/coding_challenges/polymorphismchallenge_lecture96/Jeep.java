package com.hb.study.udemylpajavamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

class Jeep extends Car{
    public Jeep(int cylinders, String name) {
        super(cylinders, name);
    }
    public void startEngine() {
        System.out.println("startEngine() inside Jeep class invoked");
    }
    public void accelerate() {
        System.out.println("accelerate() inside Jeep class invoked");
    }
    public void brake(){
        System.out.println("brake() inside Jeep class invoked");
    }
}