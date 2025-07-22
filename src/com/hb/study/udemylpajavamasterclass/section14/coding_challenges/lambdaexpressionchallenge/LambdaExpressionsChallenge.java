package com.hb.study.udemylpajavamasterclass.section14.coding_challenges.lambdaexpressionchallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntFunction;

/**
 * created by : heman on 22-07-2025, 02:33 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaExpressionsChallenge {

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
        //demoFunction();
        challengeDemo();
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    public static void challengeDemo() {
        ConsoleStyler.startSection("Lambda Expressions Challenge Demo - Arrays/ArrayList/Operation Lambda"); // required
        ConsoleStyler.styleExecutionInsight("""
                Challenge Objective:
                This challenge is designed to exercise your skills with methods on Arrays and ArrayLists, that are targets for lambda expressions.
                First, I want you to create an array of String, which is populated with first names, in mixed case.
                Include at least one name, which is spelled the same backwards, and forwards, like Bob, or Anna.
                Use Arrays.setAll, or List.replaceAll, to change the values in this array.
                If you use List methods, you'll need a list backed by the array, so that changes get made to the initial array.
                
                Using one of those two methods, perform the following functions on the elements in the array, with appropriate lambda expressions. \s
                Transform names to all uppercase.
                Add a randomly generated middle initial and include a period.
                Add a last name that is the reverse of the first name.
                Print your array or the array elements, after each change, using the forEach method, at least once.
                Finally, create a new modifiable ArrayList from your names array, removing any names where the last name equals the first name.
                Use removeIf with a lambda expression to perform this last operation.
                """);
        String[] FIRST_NAMES = { "Anna", "Bob", "Nitin", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
                "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
        };
        ConsoleStyler.styleInitializationInfo("""
                First Names Array initialized 
                for use in this challenge as below:""");
        ConsoleStyler.styleEachAsIs(null, FIRST_NAMES );

        
        ConsoleStyler.endSection("Lambda Expressions Challenge Demo - Arrays/ArrayList/Operation Lambda"); // required
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
    }
}
