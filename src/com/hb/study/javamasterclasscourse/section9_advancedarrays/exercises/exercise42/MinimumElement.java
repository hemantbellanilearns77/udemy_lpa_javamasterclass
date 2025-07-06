package com.hb.study.javamasterclasscourse.section9_advancedarrays.exercises.exercise42;

import java.util.Arrays;

public class MinimumElement {
    public static void main(String[] args) {
        int userInput = readInteger();

    }

    public static int readInteger() {
        int userInputInteger;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter an interger, " +
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
        System.out.println(Arrays.toString(newArray));
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
