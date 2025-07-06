package com.hb.study.javamasterclasscourse.section9_advancedarrays.misc_practice;

import java.util.Arrays;
import java.util.Random;

public class ArrayBasics {

    public static void main(String[] args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(63) + " The Output of " + ArrayBasics.class.getSimpleName() + " is as below " + "*".repeat(63);

        int[] myIntArray = new int[10];
        myIntArray[2] = 20;
        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 20.00;
        System.out.println(programOutputBegins);

        System.out.printf("myIntArray 3rd element: %d %n", myIntArray[2]);
        System.out.printf("myDoubleArray 3rd element: %f  %n", myDoubleArray[2]);
        System.out.println("myIntArray printed using Arrays.toString() looks like: "+Arrays.toString(myIntArray));;
        System.out.println("The lengths of " +
                "myIntArray and myDoubleArray respectively are:  " +
                myIntArray.length + " and " + myDoubleArray.length);
        System.out.println(asteriskSeparatorLine);

        //Some practice with Arrays class
        int[] firstArray = getRandomArray(10);
        System.out.println("Newly obtained Random Number Array (firstArray) is: " + Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println("Sorted firstArray is: " + Arrays.toString(firstArray));
        System.out.println(asteriskSeparatorLine);

        int[] secondArray = getRandomArray(10);
        System.out.println("secondArray initialized and before filling with all 5s: " + Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);
        System.out.println("secondArray after filling with all 5s: " + Arrays.toString(secondArray));
        System.out.println(asteriskSeparatorLine);

        int[] thirdArray =  getRandomArray(10);
        System.out.println("thirdArray is: " + Arrays.toString(thirdArray));
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println("fourthArray as copied from thirdArray is: " + Arrays.toString(fourthArray));
        System.out.println(asteriskSeparatorLine);
        String[] stringArray = {"Able","Jane","Mark","Ralph","David"};
        Arrays.sort(stringArray);
        if(Arrays.binarySearch(stringArray,"Mark") >= 0) {
            System.out.println("Mark was found in the string Array at index: " + Arrays.binarySearch(stringArray, "Mark"));
        }
        System.out.println(asteriskSeparatorLine);
        int[] testArray1 = {1,2,3,4,5};
        int[] testArray2 = {1,2,3,4,5};
        if(Arrays.equals(testArray1, testArray2)) {
            System.out.println("Arrays(testArray1, testArray2) are equal");
        } else{
            System.out.println("Arrays(testArray1, testArray2) are not equal");
        }
        System.out.println(asteriskSeparatorLine);

    }

    private static int[] getRandomArray(int len){

        Random random = new Random();
        int[] randomArray = new int[len];

        for(int i = 0; i< randomArray.length; i++) {
            randomArray[i] = random.nextInt(101);
            //randomArray[i] += random.nextInt(101);

        }
        return randomArray;
    }
}
