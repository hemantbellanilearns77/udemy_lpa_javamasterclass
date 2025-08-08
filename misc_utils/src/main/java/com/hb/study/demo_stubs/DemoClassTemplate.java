package com.hb.study.demo_stubs;

import com.hb.study.udemylpajavamasterclass.global.models.SemanticColorRole;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.List;

/**
 * created by : heman on 24-07-2025, 09:27 am, in the "udemy_lpa_javamasterclass" project
 **/
public class DemoClassTemplate {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
     

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
        demoFunction();
        execution.finalizeExecution();
    }

    public static void demoFunction() {
        ConsoleStyler.startSection("Welcome to Demo Section"); // required
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this section demo"); // optional
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Welcome to the subsection X"); // optional
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this subsection section X demo"); // optional
        ConsoleStyler.styleExecutionInsight("Regarding this sub-section.... some insights "); // optional
        List<String> dummyList= new ArrayList<>();
         //for simply printing elements , no sorting, no uppercase, no formatting on numbers etc...
            ConsoleStyler.styleEachAsIs("Label Prefix, like Name/Guest/Part: ",dummyList);
         //for printing elements and has all options:  sorting, uppercase, formatting on numbers etc...
            ConsoleStyler.styleEach("Label Prefix, like Name/Guest/Part: ",dummyList,true, true, true);
        ConsoleStyler.styleIt("Output Text", SemanticColorRole.INTRO_TEXT,true, true, true );
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
        ConsoleStyler.divider();
    }
}
