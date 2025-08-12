package com.hb.study.udemy_lpa_javamasterclass.section4_basics.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class OperatorsChallenge {
    public static void main(String[] args) {
        double myFirstValue = 20.0d;
        double mySecondValue = 80.0d;
//      The below was earlier used without parenthesis to demonstrate operator parenthesis
//      double myValuesTotal = myFirstValue + mySecondValue * 100.00d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00d;
        ConsoleStyler.styleOutput("myValuesTotal : " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;
        ConsoleStyler.styleOutput("theRemainder : " + theRemainder);
        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        if(isNoRemainder) {
            ConsoleStyler.styleOutput("There's no remainder");
        } else {
            ConsoleStyler.styleOutput("Got some remainder");
        }
    }
}
