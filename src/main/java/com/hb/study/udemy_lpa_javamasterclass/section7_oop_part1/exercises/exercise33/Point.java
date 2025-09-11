package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise33;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Point {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;

    public Point() {
        ConsoleStyler.styleOutput("The no args constructor");
    }

    public Point(int x, int y){
        ConsoleStyler.styleOutput("Constructor with arguments.....");
        this.x = x;
        this.y = y;
    }

    public double distance() {
        double distance;
        distance =  Math.sqrt( ( (double) ((-this.x)*(-this.x)) ) + ((double) ( (-this.y)*(-this.y) ) ) );
        return distance;
    }


    public double distance(Point anotherPoint) {

        double distance;

        distance = Math.sqrt( ( (double) ((anotherPoint.getX()-this.x)*(anotherPoint.getX()-this.x))) +
                ( (double) ((anotherPoint.getY()-this.y)*(anotherPoint.getY()-this.y)) ));
        return distance;
    }

    public double distance(int x, int y) {

        double distance;
        distance = Math.sqrt( ( (double) ( (x-this.x)*(x-this.x)) ) + ( (double) ((y-this.y)*(y-this.y)) ) );
        return distance;
    }
}