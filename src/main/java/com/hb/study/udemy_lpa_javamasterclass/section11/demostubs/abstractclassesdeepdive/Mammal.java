package com.hb.study.udemy_lpa_javamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


abstract class Mammal extends Animal {

    public Mammal(String type) {
        super(type);
    }

    @Override
    public void move(String speed) {

        System.out.print(getExplicitType() + " ");
        ConsoleStyler.styleOutput( speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}