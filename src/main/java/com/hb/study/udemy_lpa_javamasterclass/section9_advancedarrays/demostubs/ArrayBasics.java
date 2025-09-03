package com.hb.study.udemy_lpa_javamasterclass.section9_advancedarrays.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class ArrayBasics {

        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(63) + " The Output of " + ArrayBasics.class.getSimpleName() + " is as below " + "*".repeat(63);

        int[] myIntArray = new int[10];
        myIntArray[2] = 20;
        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 20.00;
        ConsoleStyler.styleOutput(programOutputBegins);

        System.out.printf("myIntArray 3rd element: %d %n", myIntArray[2]);
        System.out.printf("myDoubleArray 3rd element: %f  %n", myDoubleArray[2]);
        ConsoleStyler.styleOutput("myIntArray printed using Arrays.toString() looks like: "+Arrays.toString(myIntArray));;
        ConsoleStyler.styleOutput("The lengths of " +
                "myIntArray and myDoubleArray respectively are:  " +
                myIntArray.length + " and " + myDoubleArray.length);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

        //Some practice with Arrays class
        int[] firstArray = getRandomArray(10);
        ConsoleStyler.styleOutput("Newly obtained Random Number Array (firstArray) is: " + Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        ConsoleStyler.styleOutput("Sorted firstArray is: " + Arrays.toString(firstArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

        int[] secondArray = getRandomArray(10);
        ConsoleStyler.styleOutput("secondArray initialized and before filling with all 5s: " + Arrays.toString(secondArray));
        Arrays.fill(secondArray, 5);
        ConsoleStyler.styleOutput("secondArray after filling with all 5s: " + Arrays.toString(secondArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

        int[] thirdArray =  getRandomArray(10);
        ConsoleStyler.styleOutput("thirdArray is: " + Arrays.toString(thirdArray));
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        ConsoleStyler.styleOutput("fourthArray as copied from thirdArray is: " + Arrays.toString(fourthArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
        String[] stringArray = {"Able","Jane","Mark","Ralph","David"};
        Arrays.sort(stringArray);
        if(Arrays.binarySearch(stringArray,"Mark") >= 0) {
            ConsoleStyler.styleOutput("Mark was found in the string Array at index: " + Arrays.binarySearch(stringArray, "Mark"));
        }
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
        int[] testArray1 = {1,2,3,4,5};
        int[] testArray2 = {1,2,3,4,5};
        if(Arrays.equals(testArray1, testArray2)) {
            ConsoleStyler.styleOutput("Arrays(testArray1, testArray2) are equal");
        } else{
            ConsoleStyler.styleOutput("Arrays(testArray1, testArray2) are not equal");
        }
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

    }

    private static int[] getRandomArray(int len){

        SecureRandom secureRandom = new SecureRandom();
        int[] randomArray = new int[len];

        for(int i = 0; i< randomArray.length; i++) {
            randomArray[i] = secureRandom.nextInt(101);
            //randomArray[i] += random.nextInt(101);

        }
        return randomArray;
    }
}
