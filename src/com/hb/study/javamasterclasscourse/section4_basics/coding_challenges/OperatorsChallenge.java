package com.hb.study.javamasterclasscourse.section4_basics.coding_challenges;

public class OperatorsChallenge {
    public static void main(String[] args) {
        double myFirstValue = 20.0d;
        double mySecondValue = 80.0d;
//      The below was earlier used without parenthesis to demonstrate operator parenthesis
//      double myValuesTotal = myFirstValue + mySecondValue * 100.00d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00d;
        System.out.println("myValuesTotal : " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;
        System.out.println("theRemainder : " + theRemainder);
        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        if(isNoRemainder) {
            System.out.println("There's no remainder");
        } else {
            System.out.println("Got some remainder");
        }

    }
}
