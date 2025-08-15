package com.hb.study.misc_utils.demo_stubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.util.List;

/**
 * created by : heman on 13-08-2025, 08:01 pm, in the "run-pmd.bat" project
 **/
public class DemoClassTemplate {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
        // main method initializations.... 

        //your own code here; recommended to divide in function calls
        demoFunction();

        execution.finalizeExecution();
    }

    public static void demoFunction() {
        NamesUtil namesUtil = new NamesUtil(9);
        ConsoleStyler.startSection("Welcome to Demo Section"); // required
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this section demo"); // optional
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Welcome to the subsection X"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection section X demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        //for simply printing elements , no sorting, no uppercase, no formatting on numbers etc...
        ConsoleStyler.styleEachAsIs("Label Prefix, like Name/Guest/Part: ", List.of(namesUtil.getDEFAULT_FIRST_NAMES()));

        //for printing elements and has all options:  sorting, uppercase, formatting on numbers etc...
        ConsoleStyler.styleEach("Label Prefix, like Name/Guest/Part: ", List.of(namesUtil.getDEFAULT_FIRST_NAMES()), true, true, true);

        ConsoleStyler.styleOutput("Output Heading", "Plain output "); //  output
        ConsoleStyler.halfDivider();//This is required only if there is another subsection....

        ConsoleStyler.styleIntro("Welcome to the subsection Y"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection Y demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        /*
         * More output etc. for subsection Y
         * No call to method halfDivider() if this is the last-sub-section...
         */
        ConsoleStyler.endSection("End of Section, Thanks for trying this out"); // required
    }
}
