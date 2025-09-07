package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class WhileLoopChallenge {
        public static void main(String[] args) {
        //
        int loopCounter = 5;
        int countOfEvens = 0;
        int countofOdds = 0;
        while(loopCounter <= 20) {
            if(isEvenNumber(loopCounter)) {
                countOfEvens++;
                ConsoleStyler.styleOutput(loopCounter + " is the next even number found ");
                if(countOfEvens == 5){
                    ConsoleStyler.styleOutput("5 even numbers have been found....");
                    break;
                }
            } else {
                countofOdds++;
            }
            loopCounter++;
        }
        ConsoleStyler.styleOutput("Count of Odds between 5 and " + loopCounter + " is : " + countofOdds);
    }
    public static boolean isEvenNumber(int numberToCheck) {
        if( (numberToCheck % 2) != 0 )
            return false;
        return true;
    }
}
