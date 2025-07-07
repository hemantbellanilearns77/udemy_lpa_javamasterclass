package com.hb.study.javamasterclasscourse.section6_controlflow.misc_practice;

public class FirstAndLastDigitSum {
    public static void main(String[] args) {
        sumFirstAndLastDigit(0);
        sumFirstAndLastDigit(9);

    }

    public static int sumFirstAndLastDigit(int numToEvaluate){

        int firstDigit = 0, lastDigit = 0,  rem = 0, temp = 0;
        int sum = -1;
        if(numToEvaluate >= 0 ) {
            temp = numToEvaluate;
            lastDigit = temp % 10;
            //loop to find reverse number
            while (temp != 0) {
                rem = temp % 10;
                temp /= 10;
            }

            firstDigit = rem;
            System.out.println("The first and last digits are:  " + firstDigit + " and " + lastDigit);
            sum = firstDigit + lastDigit;
            System.out.println("The sum of first and last digits is :  " + (firstDigit + lastDigit));
        }
        return sum;


    }


}
