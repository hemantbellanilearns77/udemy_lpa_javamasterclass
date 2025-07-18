package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaadvanced;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.Operation;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class LambdaAdvancedDemo {
    private static ExcecutionUtil execution = new ExcecutionUtil();

    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    private static final int namesCount = new Random().nextInt(1, 64);

    public static void main(String[] args) {
        execution.initialize();
        List<String> names = new ArrayList<>();

        ConsoleStyler.styleIt("Original (unfiltered) name count: " + namesCount, false, true);
        for (int loopCounter = 0; loopCounter < namesCount; loopCounter++) {
            Name generatedFullName = new Name(CommonUtils.generateRandomName(FIRST_NAMES, LAST_NAMES));
            names.add(generatedFullName.getFirstName());
        }
        ConsoleStyler.divider();
        ConsoleStyler.styleIt("Generated names using lambda forEach:", false, true);
        //AtomicInteger lambdaLoopCounter = new AtomicInteger(1);
        // looping a list using lambda expression
        //names.forEach(nextName -> System.out.printf("[%d] %-12s%n", (lambdaLoopCounter.getAndIncrement()), nextName));
        ConsoleStyler.styleEach("Guest", names);
        ConsoleStyler.divider();

         int value1 = 7;
         int value2 = 9;

        //Lambda invocation using calculator...
        var result = calculator((a, b) -> (value1 * value2), value1, value2);
        //value2 = 20; // just to demonstrate that if uncommented this would introduce an error in above lambda expression....
        /* variations of the above lambda call
         int result = calculator((Integer v1, Integer v2) -> {
            return 'T' + (value1 * value2);
        }, value1, value2); // using final variables to be utilized
        int result = calculator((a,b) -> 'T' + (a*b), 7,9);
        int result = calculator((var a, var b) -> 'T' + (a*b), 7,9); // using var as return types
        int result = calculator((Integer a, Integer b) -> 'T' + (a*b), 7,9); explicit return types
        int result = calculator((a,b) -> {int c = a*b; return c;}, 7,9); // using return ad curly braces
         */

        ConsoleStyler.styleIt("""
        Lambda Function Applied: (a, b) -> (value1 * value2)
        Final Result from calculator:  """ + result, true, true);
        ConsoleStyler.divider();
        //Lambda invocation using anotherCalculator i.e. the BinaryOperator (out of box from java.util package) Functional Interface...
        int anotherResult = anotherCalculator((a, b) ->  (value1 * value2), value1, value2);
        ConsoleStyler.styleIt("""
        Lambda Function Applied: (a, b) -> (value1 * value2)
        Final Result from anotherCalculator:  """ + anotherResult, true, true);
        ConsoleStyler.divider();
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659},
                new double[]{45.9239, -111.4983},
                new double[]{38.8146, -90.1218}
        );
        //ConsoleStyler.styleEach("Coordinates Points", coords.iterator().next());
        ConsoleStyler.startSection("Printing all coords using coords.forEach(lambda)");
        coords.forEach(s-> ConsoleStyler.styleIt(Arrays.toString(s),false, false));
        ConsoleStyler.endSection("Printing all coords using coords.forEach(lambda)");
        ConsoleStyler.divider();
        BiConsumer<Double, Double> p1 = (lat,lon) ->
                ConsoleStyler.styleIt("[Latitude: %.3f, Longitude: %.3f]%n".formatted(lat, lon),false,false);
        //BiConsumer<Double, Double> p1 = (lat,lon) -> System.out.printf("[Latitude: %.3f, Longitude: %.3f]%n", lat, lon);
        var firstPoint = coords.get(0);
        ConsoleStyler.startSection("Playing around with BiConsumer Functional Interface ");
        processPoint(firstPoint[0], firstPoint[1], p1);
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRHALF);
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRHALF);
        System.out.println("Now with the expanded lambda expression.... ");
        coords.forEach(s -> processPoint(s[0], s[1],
                (lat,lon) ->
                        ConsoleStyler.styleIt("[Latitude: %.3f, Longitude: %.3f]%n".formatted(lat, lon),false,false)));
        ConsoleStyler.endSection("Playing around with BiConsumer Functional Interface ");
        ConsoleStyler.divider();
        execution.finalizeExecution();
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        ConsoleStyler.styleIt("Result (inside calculator method): " + result, false, true);
        return result;
    }
    // This one uses an out of box, Java Core BinaryOperator Functional Interface
    public static <T> T anotherCalculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        ConsoleStyler.styleIt("Result (inside anotherCalculator method): " + result, false, true);
        return result;
    }


    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
}

