package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Fish extends Animal{
    private int gills;
    private int fins;

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
        if(speed == "fast"){
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
