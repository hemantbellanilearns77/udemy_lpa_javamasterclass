package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise34;

public class Calculator {
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        double totalCost;
        totalCost = this.floor.getArea() * this.carpet.getCost();
        return totalCost;
    }
}
