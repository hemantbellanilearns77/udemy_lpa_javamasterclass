package com.hb.study.udemylpajavamasterclass.global.misc_codedemo;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Random;

/**
 * created by : heman on 22-07-2025, 09:11 am, in the "udemy_lpa_javamasterclass" project
 **/
public class TestClassTemplate {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final int maxElementAndIterationCount = new Random().nextInt(1, (63 + 1));

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
        // main method initializations.... 
        /*
         *****************************************************
         */
        //your own code here; recommended to divide in function calls
        demoFunction();
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    public static void demoFunction() {
        ConsoleStyler.startSection("Welcome to Demo Section"); // required
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this section demo"); // optional
        ConsoleStyler.halfDivider();
        ConsoleStyler.startSubSection("Welcome to the subsection X"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection section X demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        /* for simply printing elements , no sorting, no uppercase, no formatting on numbers etc...
            ConsoleStyler.styleEachAsIs("Label Prefix, like Name/Guest/Part: ",List<String>);
        */
        /* for printing elements and has all options:  sorting, uppercase, formatting on numbers etc...
            ConsoleStyler.styleEach("Label Prefix, like Name/Guest/Part: ",List<String>);
        */
        //ConsoleStyler.styleIt(custom styling... );
        ConsoleStyler.styleOutput("Output Heading", "Plain output "); //  output
        ConsoleStyler.halfDivider();//This is required only if there is another subsection....

        ConsoleStyler.startSubSection("Welcome to the subsection Y"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection Y demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        /*
         * More output etc. for subsection Y
         * No call to method halfDivider() if this is the last-sub-section...
         */
        ConsoleStyler.endSection("End of Section, Thanks for trying this out"); // required
        ConsoleStyler.divider();
        ;
    }
}
