package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Dog extends Mammal {

    public Dog(String type) {
        super(type);
    }

    @Override
    public void move(String speed) {

        if (speed.equals("slow")) {
            ConsoleStyler.styleOutput(getExplicitType() + " walking");
        } else {
            ConsoleStyler.styleOutput(getExplicitType() + " running");
        }

    }

    @Override
    public void shedHair() {

        ConsoleStyler.styleOutput(getExplicitType() + " shed hair all the time");
    }

    @Override
    public void makeNoise() {

        if (type.equalsIgnoreCase("Wolf")) {
             ConsoleStyler.styleOutput("Howling! ");
        } else {
             ConsoleStyler.styleOutput("Woof! ");
        }

    }
}
