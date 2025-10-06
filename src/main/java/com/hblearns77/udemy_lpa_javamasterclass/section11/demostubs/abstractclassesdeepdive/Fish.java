package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Fish extends Animal {
    public Fish(String type) {
        super(type);
    }

    @Override
    public void move(String speed) {
        if (speed.equalsIgnoreCase("slow")) {
            ConsoleStyler.styleOutput(getExplicitType() + " lazily swimming");
        } else {
            ConsoleStyler.styleOutput(getExplicitType() + " darting frantically");
        }
    }
    @Override
    public void makeNoise() {
        if (type.equalsIgnoreCase("Goldfish")) {
            ConsoleStyler.styleOutput("swish ");
        } else {
            ConsoleStyler.styleOutput("splash ");
        }
    }
}
