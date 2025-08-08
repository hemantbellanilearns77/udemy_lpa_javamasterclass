package com.hb.study.udemylpajavamasterclass.section6_controlflow.exercises.exercise20;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class LastDigitChecker {
    // write code here.
    public static void main(String[] args) {
        hasSameLastDigit (41, 22, 71);
        hasSameLastDigit (23, 32, 42);
        hasSameLastDigit (9, 99, 999);
    }
    public static boolean hasSameLastDigit(int firstNum, int secondNum, int thirdNum) {
        boolean sameLastDigitFoundTwiceOrMore = false;

        int firstNumLastDigit, secondNumLastDigit, thirdNumLastDigit;
        if( isValid(firstNum) && isValid(secondNum) && isValid(thirdNum) ){
            firstNumLastDigit = firstNum % 10;
            secondNumLastDigit = secondNum % 10;
            thirdNumLastDigit = thirdNum % 10;
            if( (firstNumLastDigit == secondNumLastDigit)
                    || (firstNumLastDigit == thirdNumLastDigit)){
                sameLastDigitFoundTwiceOrMore = true;
            } else if(secondNumLastDigit == thirdNumLastDigit) {
                sameLastDigitFoundTwiceOrMore = true;
            } else {
                // no match found
            }


        } else {
            //invalid input
        }
        ConsoleStyler.styleOutput(Boolean.toString(sameLastDigitFoundTwiceOrMore));
        return sameLastDigitFoundTwiceOrMore;
    }
    public static boolean isValid (int number) {
        return ((number >= 10) && (number <= 1000 ));
    }
}
