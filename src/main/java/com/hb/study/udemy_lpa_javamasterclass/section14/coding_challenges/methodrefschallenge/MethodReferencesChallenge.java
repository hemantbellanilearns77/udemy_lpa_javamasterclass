package com.hb.study.udemy_lpa_javamasterclass.section14.coding_challenges.methodrefschallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * created by : heman on 23-07-2025, 06:35 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class MethodReferencesChallenge {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
     
    private static final SecureRandom secureRandom = new SecureRandom();

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }

    }

    public static void main(String[] args) {
        execution.initialize(args);

        //your own code here; recommended to divide in function calls
        demoMethodRefernces();
        execution.finalizeExecution();
    }

    public static void demoMethodRefernces() {

        ConsoleStyler.startSection("Welcome to Method References Challenge Section");
        String[] firstNames = {"Anna", "Bob", "Nitin", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
                "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh"
        };
        ConsoleStyler.styleIntro("""
                Challenge Objective:
                First, create an array of names, in mixed case, as you did in the Lambda Expression Challenge.
                Create a list of Function interfaces, or alternately UnaryOperator, which will contain all the operations you want executed on each name in your array.
                Do something similar to what we did in the Lambda Expression challenge:
                Make each name upper case,
                Add a random middle initial,
                Add a last name, which should be the reverse of the first.
                In addition to this, add some custom transformations of your own.
                
                Use a mix of lambda expressions, and method references.
                Create a method that takes the name array, and the function list, and applies each function to each name, using the transform method on String, to do this.
                All changes should be applied to the original array.
                Make sure you explore as many transformations as you can, trying as many different types of method references as you can think of.""");
        Person tim = new Person("Tim");

        ConsoleStyler.styleInitializationInfo("""
                The below displayed Array of first names was initialized for this challenge:
                """);
        ConsoleStyler.styleOutput(null, Arrays.toString(firstNames));

        ConsoleStyler.halfDivider();


        List<UnaryOperator<String>> unaryOperators = new ArrayList<>();
        // Make each name upper case
        //IntFunction<String> upperCaseFunction = arrayIndex -> firstNames[arrayIndex].toUpperCase();

        UnaryOperator<String> allUppercaseUnaryLambda = String::toUpperCase;

        unaryOperators.add(allUppercaseUnaryLambda);
        // Add a randomly generated middle initial and include a period.
        UnaryOperator<String> addMiddleInitialLsLambda = (s) -> {
            return (s + " " + getRandomChar('A', 'Z') + '.');
        };
        unaryOperators.add(addMiddleInitialLsLambda);

        UnaryOperator<String> addReversedLastName = (s) -> {
            return (s += " " + getReversedName(s.substring(0, s.indexOf(" "))));
        };
        unaryOperators.add(addReversedLastName);
        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('D', 'M') + ".",
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                MethodReferencesChallenge::reverse,
                String::new,
//                s -> new String("Howdy " + s),
                String::valueOf,
                tim::last,
                (new Person("MARY"))::last

        ));

        applyTransformations(firstNames, list);


    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) secureRandom.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

    private static String reverse(String s) {
        return reverse(s, 0, s.length());
    }

    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }


    private static void applyTransformations(
            String[] firstNames, List<UnaryOperator<String>> unaryOperators) {
        List<String> backedByArray = Arrays.asList(firstNames);
        for (var unaryOperator : unaryOperators) {
           /* for(int i = 0; i < backedByArray.size(); i++) {
                backedByArray.set(i, unaryOperator.apply(backedByArray.get(i)));
            }*/
            backedByArray.replaceAll(s -> s.transform(unaryOperator));
            ConsoleStyler.styleOutput("""
                    updated backedByArray List is:
                    """, """
                    """ + Arrays.toString(firstNames));
        }
    }
}
