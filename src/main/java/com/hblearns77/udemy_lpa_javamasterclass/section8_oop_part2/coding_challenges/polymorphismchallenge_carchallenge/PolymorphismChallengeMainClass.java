package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;


import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismChallengeMainClass {

    private static final String ELECTRIC = "ELectric";
    private static final String GAS_POWERED = "GasPowered";
    private static final String HYBRID = "Hybrid";
    private static final String CAR = "Car";
    private static final String IT_RUNS_ON = "It runs on";
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String GENERIC = "Generic";
    private static final String GASOLINE = "Gasoline";

    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        List<String> listOfCarTypes = new ArrayList<>();
        listOfCarTypes.add(GENERIC);
        listOfCarTypes.add(GAS_POWERED);
        listOfCarTypes.add(ELECTRIC);
        listOfCarTypes.add(HYBRID);
        listOfCarTypes.add(CAR);

        Car car = getCarInstance(listOfCarTypes.get((int) (listOfCarTypes.size() * secureRandom.nextDouble(0.0, 1.0))));
        runCarRace(car);
        execution.finalizeExecution();
    }

    public static Car getCarInstance(String carType) {

        return switch (carType) {
            case GAS_POWERED -> new GasPoweredCar(IT_RUNS_ON + " " + ELECTRIC + " Charging");
            case ELECTRIC -> new ElectricCar(IT_RUNS_ON + " " + ELECTRIC + " Charging");
            case HYBRID -> new HybridCar(IT_RUNS_ON + " both " + GASOLINE + " " +
                    "and " + ELECTRIC + " charge ");
            default -> new Car(IT_RUNS_ON + " " + GASOLINE);
        };
    }

    public static void runCarRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
