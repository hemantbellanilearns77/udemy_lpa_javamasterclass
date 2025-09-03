package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class polymorphismchallenge_MainClass {

    private static final String ELECTRIC = "Electric";
    private static final String HYBRID = "Hybrid";
    private static final String CAR = "Car";
    private static final String IT_RUNS_ON = "It runs on";
    private static final SecureRandom secureRandom = new SecureRandom();
        public static void main(String[] ignoredUnusedArgs) {
        //
        List<String> listOfCarTypes = new ArrayList<>();
        listOfCarTypes.add("GasPowered");
        listOfCarTypes.add(ELECTRIC);
        listOfCarTypes.add(HYBRID);
        listOfCarTypes.add(CAR);

        Car car = getCarInstance(listOfCarTypes.get((int) (listOfCarTypes.size() * secureRandom.nextDouble(0.0, 1.0))));
        runCarRace(car);
    }

    public static Car getCarInstance(String carType){

        return switch(carType){
            case "Generic" ->  {yield new GasPoweredCar(IT_RUNS_ON + " Gasoline");}
            case ELECTRIC ->  {yield new ElectricCar(IT_RUNS_ON + " Electric Charging");}
            case HYBRID ->  {yield new HybridCar(IT_RUNS_ON + " both gasoline " +
                    "and electric charge ");}
            default -> {
                yield new Car(IT_RUNS_ON + " Gasoline");
            }
        };
    }
    public static void runCarRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
