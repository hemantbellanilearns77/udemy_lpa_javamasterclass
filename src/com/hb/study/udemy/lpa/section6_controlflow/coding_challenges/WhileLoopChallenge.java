package com.hb.study.udemy.lpa.section6_controlflow.coding_challenges;

public class WhileLoopChallenge {
    public static void main(String[] args) {
        int loopCounter = 5;
        int countOfEvens = 0;
        int countofOdds = 0;
        while(loopCounter <= 20) {
            if(isEvenNumber(loopCounter)) {
                countOfEvens++;
                System.out.println(loopCounter + " is the next even number found ");
                if(countOfEvens == 5){
                    System.out.println("5 even numbers have been found....");
                    break;
                }
            } else {
                countofOdds++;
            }
            loopCounter++;
        }
        System.out.println("Count of Odds between 5 and " + loopCounter + " is : " + countofOdds);
    }
    public static boolean isEvenNumber(int numberToCheck) {
        if( (numberToCheck % 2) != 0 )
            return false;
        return true;
    }
}
