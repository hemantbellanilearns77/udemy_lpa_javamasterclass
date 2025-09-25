package com.hb.study.udemy_lpa_javamasterclass.section14.coding_challenges.lambdaexpressionchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * created by : heman on 22-07-2025, 02:33 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaExpressionsChallenge {

    //Object level or Static declarations here...
    private static final ExecutionUtil execution = new ExecutionUtil();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final NamesUtil namesUtil = new NamesUtil();
    private static final String LIST_BACKED_BY_ARRAY = "List backedByArray -->";

    public static void main(String[] args) {
        execution.initialize(args);

        challengeDemo();

        execution.finalizeExecution();
    }

    public static void challengeDemo() {
        String[] firstNames = namesUtil.getDefaultFirstNames();
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

        ConsoleStyler.styleInitializationInfo("First NamesUtil Array initialized for use in this challenge as below:");
        ConsoleStyler.styleOutput(null, Arrays.toString(firstNames));
        ConsoleStyler.halfDivider();

        List<String> backedByArray = Arrays.asList(firstNames);
        UnaryOperator<String> allUppercaseUnaryLambda = String::toUpperCase;
        ConsoleStyler.styleExecutionInsight("""
                It was:
                UnaryOperator<String> allUppercaseUnaryLambda = s -> s.toUpperCase();
                But replaced with methods reference to fix a sonar.
                """);
        // Transform names to all uppercase.
        backedByArray.replaceAll(allUppercaseUnaryLambda);
        ConsoleStyler.styleOutput(LIST_BACKED_BY_ARRAY + "Transform to Uppercase", backedByArray.toString());

        ConsoleStyler.halfDivider();
        // Add a randomly generated middle initial and include a period.
        backedByArray.replaceAll(s -> s + " " + getRandomChar('A', 'Z') + '.');
        ConsoleStyler.styleOutput(LIST_BACKED_BY_ARRAY +
                "Transform to add a middle Initial with a period", backedByArray.toString());

        ConsoleStyler.halfDivider();

        //Add a last name that is the reverse of the first name.
        backedByArray.replaceAll(s -> {
            s += " " + getReversedName(s.split(" ")[0]);
            ConsoleStyler.styleOutput(s);
            return s;
        });
        ConsoleStyler.styleOutput(backedByArray.toString());
        ConsoleStyler.styleOutput(LIST_BACKED_BY_ARRAY +
                "Add reversed name as last name", CommonConstants.EMPTYSTRING + Arrays.toString(firstNames));
        ConsoleStyler.halfDivider();

        // Finally, create a new modifiable ArrayList from your names array, removing any names where the last name equals the first name.
        List<String> newList = new ArrayList<>(List.of(firstNames));
        newList.removeIf(s -> s.substring(0, s.indexOf(" ")).equals(
                s.substring(s.lastIndexOf(" ") + 1)
        ));
        ConsoleStyler.styleEachAsIs(CommonConstants.EMPTYSTRING, newList);
        ConsoleStyler.styleOutput("First NamesUtil --> Remove names where first = last",
                CommonConstants.EMPTYSTRING + Arrays.toString(firstNames));

        ConsoleStyler.endSection("Lambda Expressions Challenge Demo - Arrays/ArrayList/Operation Lambda"); // required
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) secureRandom.nextInt(startChar,  endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }
}
