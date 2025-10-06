package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class HybridCar extends Car {

    private final double avgKMsperLitre;
    int batterySize;
    int cylinders;

    public HybridCar(String description, double avgKMsperLitre, int batterySize) {
        super(description);
        this.avgKMsperLitre = avgKMsperLitre;
        this.batterySize = batterySize;
    }

    @Override
    public String toString() {
        return "HybridCar{" +
                "avgKMsperLitre=" + avgKMsperLitre +
                ", batterySize=" + batterySize +
                ", Cylinders=" + cylinders +
                '}';
    }

    public HybridCar(String description) {
        this(description, 21, 7);
    }

    @Override
    public void startEngine() {
        super.startEngine();
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
