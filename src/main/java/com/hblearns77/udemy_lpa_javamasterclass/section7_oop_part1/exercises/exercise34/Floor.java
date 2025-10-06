package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise34;

public class Floor {

    private double width;
    private double length;


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Floor(double width, double length) {
        if(width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
        if(width < 0) {
            this.length = 0;
        } else {
            this.length = length;
        }
    }

    public double getArea(){

        return this.width * this.length;
    }
}
