package com.hb.study.udemylpajavamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Fish extends Animal{
    private int gills;
    private int fins;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "small", weight);
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
