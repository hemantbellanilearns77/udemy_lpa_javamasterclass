package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise34;

public class Carpet {


    private double cost;

    public Carpet(double cost){
        if( cost <0 ) {
            this.cost = 0.0;
        } else {
            this.cost = cost;
        }
    }

    public double getCost() {
        return this.cost;
    }

    /*public void setCost(double cost){
        if( cost <0 ) {
            this.cost = 0.0;
        } else {
            this.cost = cost;
        }
    }*/
}
