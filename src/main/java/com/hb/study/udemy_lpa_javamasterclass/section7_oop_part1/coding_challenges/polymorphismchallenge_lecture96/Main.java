package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

public class Main {
    public static void main(String[] args) {
        Car car = new MiniCooper(6, "MiniCooper Convertible");
        car.startEngine();
        car.accelerate();
        car.brake();

        car = new Jeep(6, "Jeep Meridian");
        car.startEngine();
        car.accelerate();
        car.brake();

        car = new Jeep(6, "Mercedes G Class");
        car.startEngine();
        car.accelerate();
        car.brake();

        car = new Mercedes(6, "G Class GLS");
        car.startEngine();
        car.accelerate();
        car.brake();
    }
}






