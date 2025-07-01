package com.hb.study.udemy.lpa.section5_javabuildingblocksbasics.exercises.exercise5;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(1924));
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(-1200));
    }

    public static boolean isLeapYear(int year){
        boolean leapYearStatus = false;
        if( year >= 1 && year <= 9999 ) {
            if( (year % 4) == 0 ) {
                leapYearStatus = true;
                if ( year%100 == 0 ) {
                    if (year % 400 == 0) {
                        leapYearStatus = true;
                    } else {
                        leapYearStatus = false;
                    }
                }
            }
        }
         return leapYearStatus;
    }
}
