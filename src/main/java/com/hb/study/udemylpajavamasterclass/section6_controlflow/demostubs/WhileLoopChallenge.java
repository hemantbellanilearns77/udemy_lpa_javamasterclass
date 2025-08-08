package com.hb.study.udemylpajavamasterclass.section6_controlflow.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

public class WhileLoopChallenge {
    public static void main(String[] args) {
        int startOfRange = 5, loopCounter = startOfRange-1;
        int endOfRange = 20;
        int countOfOdds = 0, sumOfFirstFiveEvensInRange = 0;
        List<Integer> listOfEvens = new ArrayList<Integer>();
        while(loopCounter <= endOfRange) {
            loopCounter++;
            if( (loopCounter % 2 ) == 0) {
                //ConsoleStyler.styleOutput("Adding : " + loopCounter + " to the list of evens");
                ConsoleStyler.styleOutput("Found an even number : " + loopCounter);
                listOfEvens.add(loopCounter);
                sumOfFirstFiveEvensInRange += loopCounter;
                if(listOfEvens.size() >= 5) {
                    break;
                }
            } else {
                countOfOdds++;
            }

        }
        ConsoleStyler.styleOutput("The first 5 even numbers between " + startOfRange + " and " +
                endOfRange + " are: " + listOfEvens.toString().replaceAll("[\\[\\]]", ""));
        ConsoleStyler.styleOutput("The total number of even numbers and odd numbers between " +
                startOfRange + " and " + endOfRange + " is: " + listOfEvens.size() + " and " + countOfOdds + " respectively");
        ConsoleStyler.styleOutput("The sum of first 5 even numbers between "
                + startOfRange + " and " + endOfRange + " is: " + sumOfFirstFiveEvensInRange );
    }

    public static boolean isEvenNumber (int numberToCheck) {
        boolean isEvenStatus = false;
        if( (numberToCheck % 2) == 0) {
            isEvenStatus = true;
        }
        return isEvenStatus;
    }
}
