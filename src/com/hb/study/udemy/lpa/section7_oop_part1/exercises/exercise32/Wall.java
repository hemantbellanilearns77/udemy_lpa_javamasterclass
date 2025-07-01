package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise32;

public class Wall {

    private double width;
    private double height;

    public Wall(){
        System.out.println("The no args constructor");
        this.height = 0;
        this.width = 0;
    }

    public Wall(double width, double height){
        this.height = 0;
        this.width = 0;
        System.out.println("Constructor with arguments.....");
        if(width >= 0) {
            this.width = width;
        }
        if( height >= 0 ) {
            this.height = height;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width >= 0 ) {
            this.width = width;
        } else {
            this.width = 0;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height >= 0 ) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    public double getArea(){
        return (this.width * this.height);
    }

}
