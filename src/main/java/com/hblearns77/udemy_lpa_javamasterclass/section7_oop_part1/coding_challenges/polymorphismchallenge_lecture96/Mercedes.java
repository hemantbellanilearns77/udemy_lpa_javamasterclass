package com.hblearns77.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

 import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class Mercedes extends Car{
    private static final String INSIDE_MERCEDES_CLASS_INVOKED = "inside Mercedes class invoked";

    public Mercedes(int cylinders, String name) {

        super(cylinders,name);
    }
    @Override
    public void startEngine() {

        ConsoleStyler.styleOutput("startEngine() " + INSIDE_MERCEDES_CLASS_INVOKED);
    }
    @Override
    public void accelerate() {

        ConsoleStyler.styleOutput("accelerate() " + INSIDE_MERCEDES_CLASS_INVOKED);
    }
}

