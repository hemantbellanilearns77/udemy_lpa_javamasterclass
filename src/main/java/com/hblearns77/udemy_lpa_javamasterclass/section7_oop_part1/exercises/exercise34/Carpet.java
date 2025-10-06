package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise34;

public class Carpet {


    private double cost;

    public Carpet(double cost){
        if( cost <0 ) {
            setCost(0.0);
        } else {
            setCost(cost);
        }
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost){
        if( cost <0 ) {
            this.cost = 0.0;
        } else {
            this.cost = cost;
        }
    }
}
