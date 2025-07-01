package com.hb.study.udemy.lpa.section4_javabasics.misc_practice.exploringbasicoperators;

public class TernaryOperator {
    public static void main(String[] args) {
        System.out.println("******** Inside TernaryOperator Class..... *********");
        String makeOfCar = "Volkswagen";

        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true ;
        if(isDomestic) {
            System.out.println("This car is domestic to our country");
        } else {
            System.out.println("This car is domestic to our country");
        }

    }
}
