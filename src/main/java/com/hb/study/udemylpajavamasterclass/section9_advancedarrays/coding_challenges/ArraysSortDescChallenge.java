package com.hb.study.udemylpajavamasterclass.section9_advancedarrays.coding_challenges;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ArraysSortDescChallenge {
    public static void main(String[] args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(54) + "\t\tThe Output of "
                + ArraysSortDescChallenge.class.getSimpleName() +
                " is as below\t\t" + "*".repeat(54);
        ConsoleStyler.styleOutput(programOutputBegins);
        int[] intArrayToSort = getRandomArray(7);
        ConsoleStyler.styleOutput("Original Array is: " + Arrays.toString(intArrayToSort));
        Arrays.sort(intArrayToSort);
        ConsoleStyler.styleOutput("Original Array, when sorted in Ascending Order is:  " + Arrays.toString(intArrayToSort));
        int[] descendingSortedArray = getDesceningSortedArray(intArrayToSort);
        ConsoleStyler.styleOutput("Original Array, when sorted in Descending Order is:  " + Arrays.toString(descendingSortedArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
    }

    private static int[] getDesceningSortedArray(int[] intArrayToSort) {
        int[] descendingSortedArray = new int[intArrayToSort.length];
        for(int i = (intArrayToSort.length-1), j=0; i>=0; i--,j++ ) {
            descendingSortedArray[j] = intArrayToSort[i];
        }
        return descendingSortedArray;
    }

    private static int[] getRandomArray(int length){
        int[] randomIntArray = new int[length];
        SecureRandom secureRandomRandom  = new SecureRandom();
        for(int loopCounter=1; loopCounter<length;loopCounter++) {
            randomIntArray[loopCounter] = secureRandomRandom.nextInt(100);
        }
        return randomIntArray;
    }
}
