package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.coding_challenges.polymorphismchallenge_lecture96;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Mercedes extends Car{
    public Mercedes(int cylinders, String name) {
        super(cylinders,name);
    }
    public void startEngine() {
        ConsoleStyler.styleOutput("startEngine() inside Mercedes class invoked");
    }
    public void accelerate() {
        ConsoleStyler.styleOutput("accelerate() inside Mercedes class invoked");
    }
}

