package com.hb.study.udemylpajavamasterclass.misc_practice.datetimepractice;import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
/**
created by : heman on 14-07-2025, 01:13 pm, in the "udemy_lpa_javamasterclass" project
**/public class Test {

    //Object level or Static declarations here...
    public static ExcecutionUtil execution = new ExcecutionUtil();
    public static void main(String[] ignoredArgs) {
        execution.executionSetup();

         /*
         *****************************************************
         */
		 
		 //your code for main method goes in here
        for(int i = 0 ; i< (Integer.MAX_VALUE/63); i++){
            System.out.print(i + "-> \t");
        }

		 /*
         *****************************************************
         */
        execution.executionWindDown();
    }
}
