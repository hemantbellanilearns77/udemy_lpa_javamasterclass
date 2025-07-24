package com.hb.study.udemylpajavamasterclass.section7_oop_part1.exercises.exercise36;

public class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = 0.0;
        if(radius >= 0.0 ) {
            this.radius = radius;
        }
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea(){
            return (Math.pow(this.radius, 2) * Math.PI);
    }
}
