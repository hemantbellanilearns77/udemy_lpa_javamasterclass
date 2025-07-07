package com.hb.study.javamasterclasscourse.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

public class Car {
    private String description;
    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Starting the Engine of the Car... ");
    }
    public void drive(){
        System.out.println("Driving the Car of type: " + getClass().getSimpleName());
        runEngine();
    }
    protected void runEngine(){
        System.out.println("Running Car's Engine");
    }


}
