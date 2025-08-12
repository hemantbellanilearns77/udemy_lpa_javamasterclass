package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal() {
        ConsoleStyler.styleOutput("No argument constructor in Animal class invoked....");
    }
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public void move(String speed) {
        ConsoleStyler.styleOutput(type + " moves " + speed);
    }

    public void makeNoise() {
        ConsoleStyler.styleOutput(type + " makes some kind of noise ");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }
}
