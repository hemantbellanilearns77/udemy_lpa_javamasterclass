package com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.lambdaadvanced;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;
import com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.Operation;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class LambdaAdvancedDemo {
    private static final ExcecutionUtil execution = new ExcecutionUtil();

    public static final SecureRandom secureRandom = new SecureRandom();
    private static final String GUESTS_AFTER_REMOVE_IF = "Guests after remove if....";
    private static final String RESULT = "Result ";
    private static final String STRING_ARRAY_AFTER = "String Array after";
    private static final String GUEST_LABEL = "Guest";
    private static final String STRING_ARRAY = "String Array:";

    public static void main(String[] ignoredignoredUnusedArgs) {
        execution.initialize();
        ConsoleStyler.startSection("Demonstration Initializations");
        List<String> names = new ArrayList<>();
        ConsoleStyler.styleInitializationInfo("Count of names as originally in the list (names) is: " + CommonConstants.MAX_ITERATION_COUNT
                + "; and Original List of Guest NamesUtil is: ");
        for (int loopCounter = 0; loopCounter < CommonConstants.MAX_ITERATION_COUNT; loopCounter++) {
            names.add(new Name(NamesUtil.generateRandomName()).getFirstName());
        }
        ConsoleStyler.styleEachAsIs(GUEST_LABEL, names);
        ConsoleStyler.endSection("Demonstration Initializations");

        ConsoleStyler.startSection("Demonstration of Lambda Categories : Consumer and BiConsumer Lambda");
        demoConsumerLambda(names);
        ConsoleStyler.endSection("Demonstration of Lambda Categories : Consumer and BiConsumer Lambda");

        ConsoleStyler.startSection("Demonstration of Lambda Categories : Predicate and BiPredicate Lambda");
        demoPredicateLambda(names);
        ConsoleStyler.endSection("Demonstration of Lambda Categories : Predicate and BiPredicate Lambda");

        ConsoleStyler.startSection("Demonstration of Lambda Categories : Function and BiFunction Lambda");
        dmeoFunctionLambda(names);
        ConsoleStyler.endSection("Demonstration of Lambda Categories : Function and BiFunction Lambda");

        ConsoleStyler.startSection("Demonstration of Lambda Categories : Supplier and BiSupplier Lambda");
        demoSupplierLambda(names);
        ConsoleStyler.endSection("Demonstration of Lambda Categories : Supplier and BiSupplier Lambda");

        execution.finalizeExecution();
    }

    private static void dmeoFunctionLambda(List<String> names) {
        int value1 = 77;
        int value2 = 99;
        ConsoleStyler.styleIntro("""
                Demonstrating Binary Function Lambda using Binary Function:""");
        //Lambda invocation using calculator...
        var result = calculator((a, b) -> (a * b), value1, value2);
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result));
        // just to demonstrate that if uncommented this would introduce an error in above lambda expression....
        //variations of the above lambda call
        value2 = 20;
         int result1 = calculator((Integer v1, Integer v2) -> 'T' + (v1 * v2), value1, 40); // using final variables to be utilized
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result1));
        int result2 = calculator((a,b) -> 'T' + (a*b), 7,9);
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result2));
        int result3 = calculator((var a, var b) -> 'T' + (a*b), 7,9); // using var as return types
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result3));
        int result4 = calculator((Integer a, Integer b) -> 'T' + (a*b), 7,9); //explicit return types
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result4));
        int result5 = calculator((a,b) -> a*b, 7,9); // using return ad curly braces
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""", Integer.toString(result5));


        ConsoleStyler.halfDivider();
        //Lambda invocation using anotherCalculator i.e. the BinaryOperator (out of box from java.util package) Functional Interface...
        int finalValue2 = value2;
        int anotherResult = anotherCalculator((a, b) -> (a * b), value1, finalValue2);
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from anotherCalculator:""", Integer.toString(anotherResult));
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleIntro("NamesUtil after replace all (Unary Function Lambda Demo)");
        names.replaceAll(name -> "The name: " + name + " has " + name.length() + " characters");
        names.forEach(name -> ConsoleStyler.styleIt(name, null,false,true, false));
        ConsoleStyler.styleEachAsIs("", names);
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleIntro("Demonstrating Binary Function Lambda using Arrays.setAll");
        String[] stringArray = new String[9];
        ConsoleStyler.styleOutput(STRING_ARRAY, Arrays.toString(stringArray));
        Arrays.fill(stringArray, "STRING");
        ConsoleStyler.styleIntro(STRING_ARRAY_AFTER + " fill is: ");
        ConsoleStyler.styleOutput(STRING_ARRAY, Arrays.toString(stringArray));
        Arrays.setAll(stringArray, (i) -> stringArray[i] + " # " + (i + 1));
        ConsoleStyler.styleIntro(STRING_ARRAY_AFTER + " setAll is: ");
        ConsoleStyler.styleOutput(STRING_ARRAY, Arrays.toString(stringArray));
        ConsoleStyler.halfDivider();


    }

    private static void demoConsumerLambda(List<String> names) {
        ConsoleStyler.styleIntro("Randomly generated List<String> of names (displayed using 'Consumer' Lambda based call to List.foreach()):");

        AtomicInteger lambdaLoopCounter = new AtomicInteger(1);
        // looping a list using lambda expression
        names.forEach(nextName -> ConsoleStyler.styleOutput("[%d] %-12s%n".formatted((lambdaLoopCounter.getAndIncrement()), nextName) ));
        ConsoleStyler.styleEachAsIs(GUEST_LABEL, names);
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Printing coordinate points using (displayed using variations of  'Consumer' Lambda and BiConsumer Lambda" +
                "based call to List.foreach()):");
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659},
                new double[]{45.9239, -111.4983},
                new double[]{38.8146, -90.1218}
        );
        coords.forEach(s -> ConsoleStyler.styleOutput(null, Arrays.toString(s)));
        ConsoleStyler.halfDivider();
        BiConsumer<Double, Double> p1 = (lat, lon) ->
                ConsoleStyler.styleOutput(null, "[Latitude: %.3f, Longitude: %.3f]%n".formatted(lat, lon));
        BiConsumer<Double, Double> p2 = (lat,lon) -> ConsoleStyler.styleOutput("[Latitude: %.3f, Longitude: %.3f]%n".formatted( lat, lon));
        var firstPoint = coords.getFirst();
        ConsoleStyler.styleIntro("Playing around with BiConsumer Functional Interface ");
        processPoint(firstPoint[0], firstPoint[1], p1);
        processPoint(firstPoint[0], firstPoint[1], p2);

        ConsoleStyler.halfDivider();
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Now with the expanded lambda expression.... ");
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat, lon) ->
                        ConsoleStyler.styleOutput(null, "[Latitude: %.3f, Longitude: %.3f]%n".formatted(lat, lon))));
    }

    private static void demoSupplierLambda(List<String> names) {
        ConsoleStyler.styleIntro("Supplier get() for getting a random int and then using it to generate a sub-array out of names list");
        NamesUtil namesUtil = new NamesUtil(9);
        int count = (names.size() / 2);
        String[] randomArrayUsingLambda = new String[count];
        Supplier<Integer> supplier = () -> secureRandom.nextInt(0, NamesUtil.generateRandomName().getFirstName().length());
        for (int i = 0; i < count; i++) {

            // both below are valid lambda invocations of category Supplier with use of get() implementation
            randomArrayUsingLambda[i] = namesUtil.getDefaultFirstNames()[supplier.get()]; // more readable and s is more reusable...
            //randomArrayUsingLambda[i] = namesUtil.getDEFAULT_FIRST_NAMES[((Supplier<Integer>) () -> secureRandom.nextInt(0, FIRST_NAMES.length)).get()];
        }
        ConsoleStyler.styleEachAsIs(GUEST_LABEL, randomArrayUsingLambda);
    }

    private static void demoPredicateLambda(List<String> names) {

        ConsoleStyler.styleIntro(GUESTS_AFTER_REMOVE_IF + " equalsIgnoreCase(\"ArjunDev\") ");
        names.removeIf(name -> name.equalsIgnoreCase("ArjunDev"));
        //names.forEach((String name) -> ConsoleStyler.styleIt(name, false));
        ConsoleStyler.styleEachAsIs("", names);
        ConsoleStyler.halfDivider();
        names.removeIf(name -> name.startsWith("Ar"));
        ConsoleStyler.styleIntro(GUESTS_AFTER_REMOVE_IF + " startsWith(\"Ar\") ");
        //names.forEach((String name) -> ConsoleStyler.styleIt(name, false));
        ConsoleStyler.styleEachAsIs("", names);

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        ConsoleStyler.styleOutput(RESULT + "(inside calculator method): ", (String) result);
        return result;
    }

    // This one uses an out of box, Java Core BinaryOperator Functional Interface
    public static <T> T anotherCalculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        ConsoleStyler.styleOutput(RESULT + "(inside anotherCalculator method): ", (String) result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}

