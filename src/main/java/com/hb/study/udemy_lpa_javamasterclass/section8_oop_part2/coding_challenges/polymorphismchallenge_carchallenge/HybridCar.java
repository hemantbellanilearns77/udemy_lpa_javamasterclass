package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class HybridCar extends Car {

    private double avgKMsperLitre;
    int batterySize;
    int Cylinders;

    public HybridCar(String description, double avgKMsperLitre, int batterySize) {
        super(description);
        this.avgKMsperLitre = avgKMsperLitre;
        this.batterySize = batterySize;
    }
    public HybridCar(String description) {
        super(description);
        this.avgKMsperLitre = 21;
        this.batterySize = 7;
    }

    @Override
    public void startEngine() {
        //super.startEngine();
         ConsoleStyler.styleOutput("Starting a hybrid fuel car %n");

    }

    @Override
    public void drive() {
         ConsoleStyler.styleOutput("Driving Hybrid Car %n");
        runEngine();
    }

    @Override
    protected void runEngine() {
         ConsoleStyler.styleOutput("Running Hybrid Car's Engine");
    }
}
