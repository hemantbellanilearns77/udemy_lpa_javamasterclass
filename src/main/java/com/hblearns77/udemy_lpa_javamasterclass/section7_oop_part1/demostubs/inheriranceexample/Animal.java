package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.inheriranceexample;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Animal {
    protected String type;

    protected Animal() {
        ConsoleStyler.styleOutput("No argument constructor in Animal class invoked....");
    }
    public Animal(String type) {
        this.type = type;
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
                '}';
    }
}
