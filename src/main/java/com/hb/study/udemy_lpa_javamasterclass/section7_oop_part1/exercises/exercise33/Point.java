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
        ConsoleStyler.styleOutput("The no ignoredUnusedArgs constructor");
    }

    public Point(int x, int y){
        ConsoleStyler.styleOutput("Constructor with arguments.....");
        this.x = x;
        this.y = y;
    }

    public double distance() {
        double distance = 0.0;
        distance =  Math.sqrt((0-this.x)*(0-this.x) + (0-this.y)*(0-this.y));
        return distance;
    }


    public double distance(Point anotherPoint) {

        double distance = 0.0;

        distance = Math.sqrt((anotherPoint.getX()-this.x)*(anotherPoint.getX()-this.x) +
                (anotherPoint.getY()-this.y)*(anotherPoint.getY()-this.y));
        //distance(this.x, anotherPoint.getX(), this.y, anotherPoint.getY());

        return distance;
    }

    public double distance(int x, int y) {

        double distance = 0.0;
        distance = Math.sqrt((x-this.x)*(x-this.x) + (y-this.y)*(y-this.y)); //distance(this.x, x, this.y, y);
        return distance;
    }
}