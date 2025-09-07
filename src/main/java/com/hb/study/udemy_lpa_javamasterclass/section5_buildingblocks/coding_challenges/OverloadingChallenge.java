package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class OverloadingChallenge {
        public static void main(String[] args) {
        //
        ConsoleStyler.styleOutput("5ft, 8in = " + convertToCentimeters(5, 8) + " cm");
        ConsoleStyler.styleOutput("68in = " + convertToCentimeters(68) + " cm");
    }

    public static double convertToCentimeters(int feet, int inches) {

        int feetToInches  = (feet * 12);
        int totalInches = (feetToInches + inches);
        return convertToCentimeters(totalInches);
    }
    public static double convertToCentimeters(int inches) {

        return (inches * 2.54);
    }
}
