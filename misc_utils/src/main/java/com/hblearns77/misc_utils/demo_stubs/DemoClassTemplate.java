package com.hblearns77.misc_utils.demo_stubs;

import com.hblearns77.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.CommonUtils;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.util.List;

/**
 * created by : heman on 15-08-2025, 03:18 pm, in the "run-pmd.bat" project
 **/
public class DemoClassTemplate {//Object level or Static declarations here...
    private static final ExecutionUtil execution = new ExecutionUtil();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final NamesUtil namesUtil = new NamesUtil(CommonConstants.MAX_ITERATION_COUNT);

    public static void main(String[] args) {
        execution.initialize(args);
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
        ConsoleStyler.styleIntro("Welcome to the subsection X"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection section X demo"); // optional
        ConsoleStyler.styleExecutionInsight("""
                Regarding this sub-section.... some insights...
                Example you can generate random values using Secure Random"
                """); // optional
        ConsoleStyler.styleOutput("Random value generated between 1 and 9 using SecureRandom : " + secureRandom.nextInt(1, 10));
        //for simply printing elements , no sorting, no uppercase, no formatting on numbers etc...
        ConsoleStyler.styleEachAsIs("Label Prefix, like Name/Guest/Part: ", List.of(namesUtil.getDefaultFirstNames()));

        //for printing elements and has all options:  sorting, uppercase, formatting on numbers etc...
        ConsoleStyler.styleEach("Label Prefix, like Name/Guest/Part: ", List.of(namesUtil.getDefaultFirstNames()), true, true, true);

        ConsoleStyler.styleOutput("Output Heading", "Plain output "); //  output
        ConsoleStyler.halfDivider();//This is required only if there is another subsection....

        ConsoleStyler.styleIntro("Welcome to the subsection Y"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection Y demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        ConsoleStyler.styleOutput(CommonUtils.generateRandomString());
        /*
         * More output etc. for subsection Y
         * No call to method halfDivider() if this is the last-sub-section...
         */
        ConsoleStyler.endSection("End of Section, Thanks for trying this out"); // required
    }
}
