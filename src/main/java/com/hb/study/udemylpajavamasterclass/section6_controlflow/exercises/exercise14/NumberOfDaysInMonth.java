package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise14;

public class NumberOfDaysInMonth {
    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }
    public static int getDaysInMonth(int month, int year) {
        int monthDays = -1;
        if(!((month < 1) || (month > 12) || (year < 1) || (year > 9999)) ) {
            return switch(month) {
                case 1 -> { monthDays = 31; yield monthDays; }
                case 2 -> {
                    if(isLeapYear(year))  {   monthDays = 29 ; }
                    else { monthDays = 28 ; }
                    yield monthDays;
                }
                case 3 -> { monthDays = 31; yield monthDays; }
                case 4 -> { monthDays = 30; yield monthDays; }
                case 5 -> { monthDays = 31; yield monthDays; }
                case 6 -> { monthDays = 30; yield monthDays; }
                case 7 -> { monthDays = 31; yield monthDays; }
                case 8 -> { monthDays = 31; yield monthDays; }
                case 9 -> { monthDays = 30; yield monthDays; }
                case 10 -> { monthDays = 31; yield monthDays; }
                case 11 -> { monthDays = 30; yield monthDays; }
                case 12 -> { monthDays = 31; yield monthDays; }
                default -> { yield monthDays;}
            };
        }
        return monthDays;

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
