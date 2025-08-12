package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class PrimeNumberChallenge {
    public static void main(String[] args) {

        int primeNumbersCounter = 0;
        for(int wholeNumberCounter = 0; wholeNumberCounter <= 50; wholeNumberCounter++) {
            if(isPrime(wholeNumberCounter)) {
                primeNumbersCounter++;
                System.out.print(wholeNumberCounter + ", ");
                if(primeNumbersCounter == 3){
                    ConsoleStyler.styleOutput("Since we found 3 Prime numbers, so exiting... ");
                    break;
                } else {
                    //ConsoleStyler.styleOutput(wholeNumberCounter + " IS NOT A Prime Number, but a Composite Number or 0 or 1");
                    continue;
                }
            }
        }
            ConsoleStyler.styleOutput("\nThe total count of Prime Numbers found are: " + primeNumbersCounter);
        }


    public static boolean isPrime(int wholeNumber){
        //boolean numberisPrime = true;
        int loopCounter = 0;
        if(wholeNumber < 3) {
            //return numberisPrime;
            return false;
        }
        else {
            for (int divisor = 2; divisor <= wholeNumber/2; divisor++) {
                if(wholeNumber % divisor == 0) {
                    return false;
                }
            }
        }
        return true;
        //return numberisPrime;
    }

    /*public static boolean isPrimeNumber(int wholeNumber){
        //boolean numberisPrime = true;
        int loopCounter = 0;
        if(wholeNumber <= 2) {
            //return numberisPrime;
            return true;
        }
        else {
            if (wholeNumber % 2 != 0) {
                loopCounter = wholeNumber / 2;
                for (; loopCounter > 1; loopCounter--) {
                    if ((wholeNumber % loopCounter) == 0) {
                        return false;
                        *//*numberisPrime = false;
                        break;*//*
                    }
                }
            } else {
                //numberisPrime = false;
                return false;
            }
        }
        return true;
        //return numberisPrime;
    }*/
}
