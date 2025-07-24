package com.hb.study.udemylpajavamasterclass.section14.coding_challenges.lambdaexpressionchallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * created by : heman on 22-07-2025, 02:33 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaExpressionsChallenge {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final Random random = new Random();
    private static final int maxElementAndIterationCount = random.nextInt(1, (63 + 1));

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        // main method initializations....
        //ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
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
        ConsoleStyler.styleIntro("""
                Challenge Objective:
                This challenge is designed to exercise your skills with methods on Arrays and ArrayLists, that are targets for lambda expressions.
                First, I want you to create an array of String, which is populated with first names, in mixed case.
                Include at least one name, which is spelled the same backwards, and forwards, like Bob, or Anna.
                Use Arrays.setAll, or List.replaceAll, to change the values in this array.
                If you use List methods, you'll need a list backed by the array, so that changes get made to the initial array.
                
                Using one of those two methods, perform the following functions on the elements in the array, with appropriate lambda expressions.
                Transform names to all uppercase.
                Add a randomly generated middle initial and include a period.
                Add a last name that is the reverse of the first name.
                Print your array or the array elements, after each change, using the forEach method, at least once.
                Finally, create a new modifiable ArrayList from your names array, removing any names where the last name equals the first name.
                Use removeIf with a lambda expression to perform this last operation.
                """);
        String[] firstNames = {"Anna", "Bob", "Nitin", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
                "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
        };
        ConsoleStyler.styleInitializationInfo("""
                First Names Array initialized for use in this challenge as below:""");
        ConsoleStyler.styleOutput(null, Arrays.toString(firstNames));
        ConsoleStyler.halfDivider();

        //IntFunction<String> intFunction = i -> firstNames[i].toUpperCase();
        //Transform names to all uppercase.
        //Arrays.setAll(firstNames, intFunction);
        //ConsoleStyler.styleOutput("""
        //      "First Names" Array --> Transform to Uppercase""", Arrays.toString(firstNames));

        List<String> backedByArray = Arrays.asList(firstNames);
        UnaryOperator<String> allUppercaseUnaryLambda = (s) -> {
            return s.toUpperCase();
        };
        // Transform names to all uppercase.
        backedByArray.replaceAll(allUppercaseUnaryLambda);
        ConsoleStyler.styleOutput("""
                List "backedByArray" --> Transform to Uppercase""", """
                """ + backedByArray.toString());

        ConsoleStyler.halfDivider();
        // Add a randomly generated middle initial and include a period.
        backedByArray.replaceAll((s) -> {
            return (s + " " + getRandomChar('A', 'Z') + '.');
        });
        ConsoleStyler.styleOutput("""
                List "backedByArray" --> Transform to add a middle Initial with a period
                """, """
                """ + backedByArray.toString());
        ConsoleStyler.halfDivider();

        //Add a last name that is the reverse of the first name.
        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        ConsoleStyler.styleOutput("""
                List backedByArray --> Add reversed name as last name
                """, """
                """ + Arrays.toString(firstNames));
        //Arrays.asList(firstNames).forEach(s -> ConsoleStyler.styleOutput(null,s));
        ConsoleStyler.halfDivider();

        // Finally, create a new modifiable ArrayList from your names array, removing any names where the last name equals the first name.
        List<String> newList = new ArrayList<>(List.of(firstNames));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));
/*        newList.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") + 1);
            return first.equals(last);
        });*/
        ConsoleStyler.styleOutput("First Names --> Remove names where first = last", """
                """ + Arrays.toString(firstNames));
        //Arrays.asList(firstNames).forEach(s -> ConsoleStyler.styleOutput(null,s));
        //ConsoleStyler.styleEachAsIs(null, newList.toArray() );

        ConsoleStyler.endSection("Lambda Expressions Challenge Demo - Arrays/ArrayList/Operation Lambda"); // required

    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
     /*Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to Uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));

        List<String> newList = new ArrayList<>(List.of(names));
//        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
//                s.substring(s.lastIndexOf(" ") + 1)
//        ));
        newList.removeIf(s -> {
        String first = s.substring(0, s.indexOf(" "));
        String last = s.substring(s.lastIndexOf(" ") + 1);
        return first.equals(last);
    });
        System.out.println("--> Remove names where first = last");
        newList.forEach(s -> System.out.println(s));*/
}
