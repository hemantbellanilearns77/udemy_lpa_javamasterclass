package com.hb.study.udemy.lpa.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

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
        System.out.printf("Starting a hybrid fuel car %n");

    }

    @Override
    public void drive() {
        System.out.printf("Driving Hybrid Car %n");
        runEngine();
    }

    @Override
    protected void runEngine() {
        System.out.printf("Running Hybrid Car's Engine");
    }
}
