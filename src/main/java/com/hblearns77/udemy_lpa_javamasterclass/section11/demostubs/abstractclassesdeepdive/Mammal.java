package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

abstract class Mammal extends Animal {

    protected Mammal(String type) {
        super(type);
    }

    @Override
    public void move(String speed) {
        ConsoleStyler.styleOutput(getExplicitType() + " ");
        ConsoleStyler.styleOutput(speed.equalsIgnoreCase("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}