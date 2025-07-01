package com.hb.study.udemy.lpa.section6_controlflow.exercises.exercise19;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.print("Do 12 and 23 have any shared digit?: ");
        System.out.println(hasSharedDigit(12, 23));
        System.out.print("Do 9 and 99 have any shared digit?: ");
        System.out.println(hasSharedDigit(9, 99));
        System.out.print("Do 15 and 55 have any shared digit?: ");
        System.out.println(hasSharedDigit(15, 55));
}

    public static boolean hasSharedDigit (int firstNumber, int secondNumber) {

        boolean sharedDigitsFound = false;
        int firstNumOnesDigit, secondNumOnesDigit, firstNumTensDigit, secondNumTensDigit;
        if( !(firstNumber < 10 || firstNumber > 99 || secondNumber < 10 || secondNumber > 99 )){
            firstNumOnesDigit = firstNumber / 10;
            firstNumTensDigit = firstNumber % 10;
            secondNumOnesDigit = secondNumber / 10;
            secondNumTensDigit = secondNumber % 10;
            if( (firstNumOnesDigit == secondNumOnesDigit)
                    || (firstNumOnesDigit == secondNumTensDigit)
            ){
                System.out.println("Yes, found a shared digit : " + firstNumOnesDigit);
                sharedDigitsFound = true;
            } else if((firstNumTensDigit == secondNumOnesDigit)
                    || (firstNumTensDigit == secondNumTensDigit)){
                System.out.println("Yes, found a shared digit : " + firstNumTensDigit);
                sharedDigitsFound = true;
            } else {
                System.out.println("No Shared Digit found");
            }
        } else {
            System.out.println("Invalid numbers input... ");
        }
    return sharedDigitsFound;
    }
}
