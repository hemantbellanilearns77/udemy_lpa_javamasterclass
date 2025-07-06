package com.hb.study.javamasterclasscourse.section9_advancedarrays.exercises.exercise41;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(54) + "\t\tThe Output of " + SortedArray.class.getSimpleName() + " is as below\t\t" + "*".repeat(54);
        System.out.println(programOutputBegins);
        int[] unsortedArray = getIntegers(5);
        System.out.println("unsortedArray is: " + Arrays.toString(unsortedArray));
        int[] sortedArray = sortIntegers(unsortedArray);
        printArray(sortedArray);
    }

    public static void printArray(int[] sortedArray) {
        for(int i=0; i< sortedArray.length;i++){
            System.out.println("Element "+ i + " contents " + sortedArray[i]);
        }
    }

    public static int[] sortIntegers(int[] intArrayToSort) {
        int[] descendingSortedArray = new int[intArrayToSort.length];
        Arrays.sort(intArrayToSort);
        for(int i = (intArrayToSort.length-1), j=0; i>=0; i--,j++ ) {
            descendingSortedArray[j] = intArrayToSort[i];
        }
        return descendingSortedArray;

    }

    public static int[] getIntegers(int length) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int[] newUnsortedArray = new int[length];
        for(int i = 0; i < length; i++) {

           newUnsortedArray[i] = scanner.nextInt();
        }
        return newUnsortedArray;
    }
}
