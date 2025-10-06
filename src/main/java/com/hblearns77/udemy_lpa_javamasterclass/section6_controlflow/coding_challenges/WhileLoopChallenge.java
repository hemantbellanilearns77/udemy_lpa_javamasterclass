package com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class WhileLoopChallenge {
    public static final ExecutionUtil execution = new ExecutionUtil();
        public static void main(String[] args) {
        execution.initialize(args);
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
        execution.finalizeExecution();
    }
    public static boolean isEvenNumber(int numberToCheck) {
        return (numberToCheck % 2) == 0;
    }
}
