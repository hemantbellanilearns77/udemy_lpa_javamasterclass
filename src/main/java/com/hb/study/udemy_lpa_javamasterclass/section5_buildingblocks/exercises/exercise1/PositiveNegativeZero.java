package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.exercises.exercise1;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class PositiveNegativeZero {

    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-9);
        checkNumber(0);
    }
    public static void checkNumber(int number) {
        if(number == 0) {
            ConsoleStyler.styleOutput("zero");
        } else {
            if(number > 0) {
                ConsoleStyler.styleOutput("positive");
            }
            else {
                ConsoleStyler.styleOutput("negative");
            }
        }
    }
}

