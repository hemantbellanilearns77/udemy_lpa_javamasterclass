package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.polymorphismchallenge_carchallenge;

import java.util.ArrayList;
import java.util.List;

public class polymorphismchallenge_MainClass {
    public static void main(String[] args) {
        List<String> listOfCarTypes = new ArrayList<>();
        listOfCarTypes.add("GasPowered");
        listOfCarTypes.add("Electric");
        listOfCarTypes.add("Hybrid");
        listOfCarTypes.add("Car");

        Car car = getCarInstance(listOfCarTypes.get((int) (listOfCarTypes.size() * Math.random())));
        runCarRace(car);
    }

    public static Car getCarInstance(String carType){

        return switch(carType){
            case "Generic" ->  {yield new GasPoweredCar("It runs on Gasoline");}
            case "Electric" ->  {yield new ElectricCar("It runs on Electric Charging");}
            case "Hybrid" ->  {yield new HybridCar("It runs on both gasoline " +
                    "and electric charge ");}
            default -> {
                yield new Car("It runs on Gasoline");
            }
        };
    }
    public static void runCarRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
