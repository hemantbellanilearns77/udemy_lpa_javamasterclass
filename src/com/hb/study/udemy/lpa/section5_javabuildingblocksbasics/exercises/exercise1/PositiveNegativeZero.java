package com.hb.study.udemy.lpa.section5_javabuildingblocksbasics.exercises.exercise1;

public class PositiveNegativeZero {

    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-9);
        checkNumber(0);
    }
    public static void checkNumber(int number) {
        if(number == 0) {
            System.out.println("zero");
        } else {
            if(number > 0) {
                System.out.println("positive");
            }
            else {
                System.out.println("negative");
            }
        }
    }
}

