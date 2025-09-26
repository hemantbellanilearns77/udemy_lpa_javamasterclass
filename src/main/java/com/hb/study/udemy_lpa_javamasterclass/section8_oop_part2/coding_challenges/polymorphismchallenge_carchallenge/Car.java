package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Car {
    private final String description;
    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        ConsoleStyler.styleOutput("Starting the Engine of the Car... " +
                "CommonConstants.NEWLINE This car can be described as: " + this.description);
    }
    public void drive(){
        ConsoleStyler.styleOutput("Driving the Car of type: " + getClass().getSimpleName());
        runEngine();
    }
    protected void runEngine(){
        ConsoleStyler.styleOutput("Running Car's Engine");
    }

}
