package com.hb.study.udemy_lpa_javamasterclass.section9_advancedarrays.exercises.exercise42;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;

public class MinimumElement {
        public static void main(String[] unusedArgs) {
        //
        int userInput = readInteger();

    }

    public static int readInteger() {
        int userInputInteger;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ConsoleStyler.styleOutput("Please enter an interger, " +
                "which would represents how many elements the user needs to enter");
        userInputInteger = scanner.nextInt();
        return userInputInteger;
    }
    private static int[] readElements(int userInputInteger){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int[] newArray = new int[userInputInteger];
        for(int i = 0; i < userInputInteger; i++) {

            newArray[i] = scanner.nextInt();
        }
        ConsoleStyler.styleOutput(Arrays.toString(newArray));
        return newArray;
    }

    private static int findMin(int[] arrayToFindMin) {
        int minimumVal = Integer.MAX_VALUE;
        for(int nextIntElement: arrayToFindMin){
            if(nextIntElement < minimumVal) {
                minimumVal = nextIntElement;
            }
        }
        return minimumVal;
    }
}
