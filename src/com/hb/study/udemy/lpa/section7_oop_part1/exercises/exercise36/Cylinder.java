package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise36;

public class Cylinder extends Circle{
    private double height;
    public Cylinder(double radius, double height){
        super(radius);
        if(height < 0.0) {
            this.height = 0.00;
        } else {
            this.height = height;
        }
    }
    public double getHeight() {
        return this.height;
    }
    public double getVolume() {
        return (getArea() * getHeight());

    }
 }
