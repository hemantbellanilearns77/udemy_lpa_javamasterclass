package com.hb.study.udemy_lpa_javamasterclass.section9_advancedarrays.exercises.exercise43;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


public class ReverseArray {
        public static void main(String[] ignoredUnusedArgs) {
       ;
        int [] array = {1, 2, 3, 4, 5};
        reverse(array);

    }
    private static void reverse(int[] arrayParam){

        ConsoleStyler.styleOutput("Array = " + java.util.Arrays.toString(arrayParam));
        int tempValue;
        for(int i=0, j=(arrayParam.length-1) ;i< ((arrayParam.length)/2);
        i++,j--){
            tempValue = arrayParam[i];
            arrayParam[i]=arrayParam[j];
            arrayParam[j]=tempValue;
        }
        ConsoleStyler.styleOutput("Reversed array = " + java.util.Arrays.toString(arrayParam));

    }
}
