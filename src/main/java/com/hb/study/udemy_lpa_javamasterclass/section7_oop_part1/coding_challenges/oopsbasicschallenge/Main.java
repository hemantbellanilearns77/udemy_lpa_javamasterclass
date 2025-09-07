package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.oopsbasicschallenge;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class Main {

        public static void main(String[] args) {
        //

        Car car = new Car();
        car.setMake("Porsche");
        car.setModel("Carrera");
        car.setDoors(2);
        car.setConvertible(true);
        car.setColor("black");
         ConsoleStyler.styleOutput("make = " + car.getMake());
         ConsoleStyler.styleOutput("model = " + car.getModel());
        car.describeCar();

        Car targa = new Car();
        targa.setMake("Porsche");
        targa.setModel("Targa");
        targa.setDoors(2);
        targa.setConvertible(false);
        targa.setColor("red");

        targa.describeCar();
    }
}
