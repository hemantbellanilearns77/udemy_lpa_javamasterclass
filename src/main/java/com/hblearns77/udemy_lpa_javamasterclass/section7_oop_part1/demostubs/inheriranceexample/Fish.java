package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Objects;

public class Fish extends Animal{
    private final int gills;
    private final int fins;

    public Fish(String type, int gills, int fins) {
        super(type);
        this.gills = gills;
        this.fins = fins;
    }

    public void moveMuscles(){
        ConsoleStyler.styleOutput("muscles moving");
    }

    public void moveBackFin(){
        ConsoleStyler.styleOutput("Back Fin moving");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if(Objects.equals(speed, "fast")){
            moveBackFin();
        }

    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
