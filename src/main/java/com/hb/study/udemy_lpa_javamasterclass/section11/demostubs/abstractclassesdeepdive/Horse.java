package com.hb.study.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Horse extends Mammal{
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        ConsoleStyler.styleOutput("Neigh!");

    }

    @Override
    public void shedHair() {
        ConsoleStyler.styleOutput(getExplicitType() + " sheds in the spring");
    }
}
