package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

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
        ConsoleStyler.styleOutput("Starting a electric car");
    }

    @Override
    public void drive() {
        super.drive();
        ConsoleStyler.styleOutput("Driving Electric Car  " +
                "Its average miles per charge is : " + this.avgKMsperCHarge);
        runEngine();

    }

    @Override
    protected void runEngine() {
        ConsoleStyler.styleOutput("Running Electric Car's Engine");
    }
}
