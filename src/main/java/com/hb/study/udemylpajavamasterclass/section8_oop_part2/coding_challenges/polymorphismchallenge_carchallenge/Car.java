package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Car {
    private String description;
    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        ConsoleStyler.styleOutput("Starting the Engine of the Car... ");
    }
    public void drive(){
        ConsoleStyler.styleOutput("Driving the Car of type: " + getClass().getSimpleName());
        runEngine();
    }
    protected void runEngine(){
        ConsoleStyler.styleOutput("Running Car's Engine");
    }


}
