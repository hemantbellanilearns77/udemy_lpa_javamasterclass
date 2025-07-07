package com.hb.study.javamasterclasscourse.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

public class Mercedes extends Car{
    public Mercedes(int cylinders, String name) {
        super(cylinders,name);
    }
    public void startEngine() {
        System.out.println("startEngine() inside Mercedes class invoked");
    }
    public void accelerate() {
        System.out.println("accelerate() inside Mercedes class invoked");
    }
}

