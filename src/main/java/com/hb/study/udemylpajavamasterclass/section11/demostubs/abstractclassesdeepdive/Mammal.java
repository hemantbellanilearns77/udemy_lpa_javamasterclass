package com.hb.study.udemylpajavamasterclass.section11.demostubs.abstractclassesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

abstract class Mammal extends Animal {

    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        System.out.print(getExplicitType() + " ");
        ConsoleStyler.styleOutput( speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}