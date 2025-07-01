package com.hb.study.udemy.lpa.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

class MiniCooper extends Car{
    public MiniCooper(int cylinders, String name) {
        super(cylinders,name);
    }
    public void startEngine() {
        System.out.println("startEngine() inside MiniCooper class invoked");
    }
    public void accelerate() {
        System.out.println("accelerate() inside MiniCooper class invoked");
    }
    public void brake(){
        System.out.println("brake() inside MiniCooper class invoked");
    }
}