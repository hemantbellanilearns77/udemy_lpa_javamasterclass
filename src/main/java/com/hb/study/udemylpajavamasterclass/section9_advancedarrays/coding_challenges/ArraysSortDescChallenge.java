package com.hb.study.udemylpajavamasterclass.section9_advancedarrays.coding_challenges;

import java.util.Arrays;
import java.util.Random;

public class ArraysSortDescChallenge {
    public static void main(String[] args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(54) + "\t\tThe Output of "
                + ArraysSortDescChallenge.class.getSimpleName() +
                " is as below\t\t" + "*".repeat(54);
        System.out.println(programOutputBegins);
        int[] intArrayToSort = getRandomArray(7);
        System.out.println("Original Array is: " + Arrays.toString(intArrayToSort));
        Arrays.sort(intArrayToSort);
        System.out.println("Original Array, when sorted in Ascending Order is:  " + Arrays.toString(intArrayToSort));
        int[] descendingSortedArray = getDesceningSortedArray(intArrayToSort);
        System.out.println("Original Array, when sorted in Descending Order is:  " + Arrays.toString(descendingSortedArray));
        System.out.println(asteriskSeparatorLine);
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
        Random random = new Random(1);
        for(int loopCounter=0; loopCounter<length;loopCounter++) {
            randomIntArray[loopCounter] = random.nextInt(100);
        }
        return randomIntArray;
    }
}
