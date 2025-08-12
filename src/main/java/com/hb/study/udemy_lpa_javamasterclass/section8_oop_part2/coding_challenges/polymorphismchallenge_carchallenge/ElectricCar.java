package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

public class ElectricCar extends Car {
    private double avgKMsperCHarge;
    int batterySize;

    public ElectricCar(String description, double avgKMsperCHarge, int batterySize) {
        super(description);
        this.avgKMsperCHarge = avgKMsperCHarge;
        this.batterySize = batterySize;
    }
    public ElectricCar(String description) {
        super(description);
        this.avgKMsperCHarge = 21;
        this.batterySize = 7;
    }

    @Override
    public void startEngine() {
        System.out.printf("Starting a electric car %n");
    }

    @Override
    public void drive() {
        //super.drive();
        System.out.printf("Driving Electric Car %n");
        runEngine();

    }

    @Override
    protected void runEngine() {
        System.out.printf("Running Electric Car's Engine");
    }
}
