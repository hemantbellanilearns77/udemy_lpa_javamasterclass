package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

public class GasPoweredCar extends Car {
    private double avgKMsperLitre;
    int cylinders;

    public GasPoweredCar(String description, double avgKMsperLitre, int cylinders) {
        super(description);
        this.avgKMsperLitre = avgKMsperLitre;
        this.cylinders = cylinders;
    }
    public GasPoweredCar(String description) {
        super(description);
        this.avgKMsperLitre = 21;
        this.cylinders = 6;
    }

    @Override
    public void startEngine() {
        //super.startEngine();
        System.out.printf("Starting engine of a gas powered car %n");
    }

    @Override
    public void drive() {
        System.out.printf("Driving Gas Powered Car %n");
        runEngine();
    }

    @Override
    protected void runEngine() {
        //super.runEngine();
        System.out.printf("Running Gas Powered Car's Engine");
    }
}
