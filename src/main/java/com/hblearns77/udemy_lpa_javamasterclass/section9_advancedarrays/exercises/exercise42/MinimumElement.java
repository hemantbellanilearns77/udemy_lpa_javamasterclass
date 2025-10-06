package com.hblearns77.udemy_lpa_javamasterclass.section9_advancedarrays.exercises.exercise42;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.Arrays;

public class MinimumElement {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        int userInput = readInteger();
        int[] elementArray = readElements(userInput);

        ConsoleStyler.styleOutput("The minimum number in Array of Elements: { " +
                Arrays.toString(elementArray) +
                " } with: " + userInput +
                " number of elements, is: " + findMin(elementArray));
        execution.finalizeExecution();
    }

    public static int readInteger() {
        int userInputInteger;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ConsoleStyler.styleOutput("Please enter an integer, " +
                "which would represents how many elements the user needs to enter");
        userInputInteger = scanner.nextInt();
        return userInputInteger;
    }

    private static int[] readElements(int userInputInteger) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        ConsoleStyler.styleOutput("Please enter " + userInputInteger + " numbers pressing \"enter\" key after every number");
        int[] newArray = new int[userInputInteger];
        for (int i = 0; i < userInputInteger; i++) {
            newArray[i] = scanner.nextInt();
        }
        ConsoleStyler.styleOutput(Arrays.toString(newArray));
        return newArray;
    }

    private static int findMin(int[] arrayToFindMin) {
        int minimumVal = Integer.MAX_VALUE;
        for (int nextIntElement : arrayToFindMin) {
            if (nextIntElement < minimumVal) {
                minimumVal = nextIntElement;
            }
        }
        return minimumVal;
    }
}
