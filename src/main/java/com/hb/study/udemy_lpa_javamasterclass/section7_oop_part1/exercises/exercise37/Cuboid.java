package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise37;

public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = 0.00;
        if(height >= 0.00) {
            this.height = height;
        }
    }
    public double getVolume() {
        return ( (super.getArea()) * getHeight() );
    }
    public double getHeight() {
        return height;
    }

}
