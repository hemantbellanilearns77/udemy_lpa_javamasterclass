package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class GasPoweredCar extends Car {
    private final double avKMPerLitre;
    int cylinders;

    public GasPoweredCar(String description, double avKMPerLitre, int cylinders) {
        super(description);
        this.avKMPerLitre = avKMPerLitre;
        this.cylinders = cylinders;
    }
    public GasPoweredCar(String description) {
        super(description);
        this.avKMPerLitre = 21;
        this.cylinders = 6;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        ConsoleStyler.styleOutput("Starting engine of a gas powered car");
    }

    @Override
    public void drive() {
        ConsoleStyler.styleOutput("Driving Gas Powered Car");
        runEngine();
    }

    @Override
    protected void runEngine() {
        ConsoleStyler.styleOutput("Running Gas Powered Car's Engine; its efficiency is: " + this.avKMPerLitre + " in average charge-hours per Km");
    }
}
