package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class PrimeNumberChallenge {
        public static void main(String[] unusedArgs) {
        //

        int primeNumbersCounter = 0;
        for(int wholeNumberCounter = 0; wholeNumberCounter <= 50; wholeNumberCounter++) {
            if(isPrime(wholeNumberCounter)) {
                primeNumbersCounter++;
                ConsoleStyler.styleOutput(wholeNumberCounter + ", ");
                if(primeNumbersCounter == 3){
                    ConsoleStyler.styleOutput("Since we found 3 Prime numbers, so exiting... ");
                    break;
                } else {
                    ConsoleStyler.styleExecutionInsight(wholeNumberCounter + """
                            IS NOT A Prime Number, but a Composite Number or 0 or 1.
                            Hence continuing to loop till loop limit is reached.
                            """);

                }
            }
        }
            ConsoleStyler.styleOutput("\nThe total count of Prime Numbers found are: " + primeNumbersCounter);
            ConsoleStyler.styleExecutionInsight("""
                    If you have access to code of this program, here's an potentially alternative implementation:
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
                    """);
        }


    public static boolean isPrime(int wholeNumber){
        boolean numberisPrime = true;
        if(wholeNumber < 3) {
            numberisPrime = false;
        }
        else {
            for (int divisor = 2; divisor <= wholeNumber/2; divisor++) {
                if (wholeNumber % divisor == 0) {
                    numberisPrime = false;
                    break;
                }
            }
        }
        return numberisPrime;
    }


}
