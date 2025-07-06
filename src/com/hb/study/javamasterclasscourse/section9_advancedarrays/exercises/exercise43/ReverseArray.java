package com.hb.study.javamasterclasscourse.section9_advancedarrays.exercises.exercise43;

public class ReverseArray {
    public static void main(String[] args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(63) + " The Output of " +  ReverseArray.class.getSimpleName() + " is as below " + "*".repeat(63);
        System.out.println(programOutputBegins);
        int [] array = {1, 2, 3, 4, 5};
        reverse(array);

    }
    private static void reverse(int[] arrayParam){

        System.out.println("Array = " + java.util.Arrays.toString(arrayParam));
        int tempValue;
        for(int i=0, j=(arrayParam.length-1) ;i< ((arrayParam.length)/2);
        i++,j--){
            tempValue = arrayParam[i];
            arrayParam[i]=arrayParam[j];
            arrayParam[j]=tempValue;
        }
        System.out.println("Reversed array = " + java.util.Arrays.toString(arrayParam));

    }
}
