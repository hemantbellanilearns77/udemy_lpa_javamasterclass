package com.hb.study.udemy.lpa.section5_javabuildingblocksbasics.coding_challenges;

public class OverloadingChallenge {
    public static void main(String[] args) {
        System.out.println("5ft, 8in = " + convertToCentimeters(5, 8) + " cm");
        System.out.println("68in = " + convertToCentimeters(68) + " cm");
    }

    public static double convertToCentimeters(int feet, int inches) {

        int feetToInches  = (feet * 12);
        int totalInches = feetToInches + inches;
        double conversionResult  = convertToCentimeters(totalInches);
        return conversionResult;
    }
    public static double convertToCentimeters(int inches) {

        double conversionResult = inches * 2.54;
        return conversionResult;
    }
}
