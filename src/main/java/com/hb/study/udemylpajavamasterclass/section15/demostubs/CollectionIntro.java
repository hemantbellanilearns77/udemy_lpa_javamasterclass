package com.hb.study.udemylpajavamasterclass.section15.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/**
 * created by : heman on 30-07-2025, 07:36 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CollectionIntro {

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
        dummyDemoFunction();
        //demoFunction();
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    private static void dummyDemoFunction() {
        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
       ConsoleStyler.styleEachAsIs("Name -> " , names);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
    }

    public static void demoFunction() {
        ConsoleStyler.startSection("Welcome to Demo Section"); // required
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this section demo"); // optional
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Welcome to the subsection X"); // optional
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
