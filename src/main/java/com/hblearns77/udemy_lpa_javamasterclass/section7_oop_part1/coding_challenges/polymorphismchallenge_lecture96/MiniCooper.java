package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


class MiniCooper extends Car{
    private static final String INSIDE_MINI_COOPER_CLASS_INVOKED = "inside MiniCooper class invoked";

    public MiniCooper(int cylinders, String name) {

        super(cylinders,name);
    }
    @Override
    public void startEngine() {

        ConsoleStyler.styleOutput("startEngine() " + INSIDE_MINI_COOPER_CLASS_INVOKED);
    }
    @Override
    public void accelerate() {

        ConsoleStyler.styleOutput("accelerate() " + INSIDE_MINI_COOPER_CLASS_INVOKED);
    }
    @Override
    public void brake(){

        ConsoleStyler.styleOutput("brake() " + INSIDE_MINI_COOPER_CLASS_INVOKED);
    }
}