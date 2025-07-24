package com.hb.study.udemylpajavamasterclass.section7_oop_part1.exercises.exercise37;

public class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = 0.00;
        this.length = 0.00;
        if(width >= 0) {
            this.width = width;
        } if(length  >= 0) {
            this.length = length;
        }
    }

    public double getArea() {
        return (getWidth() * getLength());
    }
    public double getWidth() {
        return width;
    }

     public double getLength() {
        return length;
    }


}
