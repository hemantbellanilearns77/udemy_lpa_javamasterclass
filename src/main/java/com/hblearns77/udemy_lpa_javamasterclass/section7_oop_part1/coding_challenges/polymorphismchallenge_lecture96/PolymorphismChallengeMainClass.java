package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class PolymorphismChallengeMainClass {

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
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
        execution.finalizeExecution();
    }
}






