package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaadvanced;import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import java.util.Random;
/**
created by : heman on 19-07-2025, 04:16 pm, in the "udemy_lpa_javamasterclass" project
**/public class Test {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };
    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
    private static final int maxElementAndIterationCount = new Random().nextInt(1, (63 + 1));
    
    public static void main(String[] ignoredArgs) {
        execution.initialize();

         /*
         *****************************************************
         */
		 
		ConsoleStyler.startSection("Demonstration of XYZ Concept....");
        demoFunction();
        ConsoleStyler.endSection("Demonstration of XYZ Concept....");

		 /*
         *****************************************************
         */
        execution.finalizeExecution();
    }
    
    public static void demoFunction(){
    }
}
