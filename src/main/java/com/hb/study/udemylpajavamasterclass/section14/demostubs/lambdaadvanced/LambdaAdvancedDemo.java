package com.hb.study.udemylpajavamasterclass.section14.demostubs.lambdaadvanced;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section14.demostubs.Operation;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class LambdaAdvancedDemo {
    private static final ExcecutionUtil execution = new ExcecutionUtil();

    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

     


    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.startSection("Demonstration Initializations");
        List<String> names = new ArrayList<>();
        ConsoleStyler.styleInitializationInfo("Count of names as originally in the list (names) is: " + CommonConstants.MAX_ITERATION_COUNT
                + "; and Original List of Guest Names is: ");
        for (int loopCounter = 0; loopCounter < CommonConstants.MAX_ITERATION_COUNT; loopCounter++) {
            names.add(new Name(CommonUtils.generateRandomName(FIRST_NAMES, LAST_NAMES)).getFirstName());
        }
        ConsoleStyler.styleEachAsIs("Guest", names);
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

        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from calculator:""",Integer.toString(result));
        ConsoleStyler.halfDivider();
        //Lambda invocation using anotherCalculator i.e. the BinaryOperator (out of box from java.util package) Functional Interface...
        int anotherResult = anotherCalculator((a, b) -> (value1 * value2), value1, value2);
        ConsoleStyler.styleOutput("""
                Lambda Function Applied: (a, b) -> (value1 * value2)
                Final Result from anotherCalculator:""", Integer.toString(anotherResult));
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleIntro("Names after replace all (Unary Function Lambda Demo)");
        names.replaceAll(name-> "The name: " + name + " has " + name.length() + " characters" );
        //names.forEach(name -> ConsoleStyler.styleIt(name, true, false));
        ConsoleStyler.styleEachAsIs("", names);
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleIntro("Demonstrating Binary Function Lambda using Arrays.setAll");
        String[] stringArray = new String[9];
        ConsoleStyler.styleOutput("String Array:" , Arrays.toString(stringArray));
        Arrays.fill(stringArray,"STRING");
        ConsoleStyler.styleIntro("String Array after fill is: ");
        ConsoleStyler.styleOutput("String Array:" ,Arrays.toString(stringArray));
        Arrays.setAll(stringArray, (i) -> stringArray[i] + " # " + (i+1) );
        ConsoleStyler.styleIntro("String Array after setAll is: ");
        ConsoleStyler.styleOutput("String Array:" ,Arrays.toString(stringArray));
        ConsoleStyler.halfDivider();



    }

    private static void demoConsumerLambda(List<String> names) {
        ConsoleStyler.styleIntro("Randomly generated List<String> of names (displayed using 'Consumer' Lambda based call to List.foreach()):");

        //AtomicInteger lambdaLoopCounter = new AtomicInteger(1);
        // looping a list using lambda expression
        //names.forEach(nextName -> System.out.printf("[%d] %-12s%n", (lambdaLoopCounter.getAndIncrement()), nextName));
        ConsoleStyler.styleEachAsIs("Guest", names);
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
                ConsoleStyler.styleOutput(null,"[Latitude: %.3f, Longitude: %.3f]%n".formatted(lat, lon));
        //BiConsumer<Double, Double> p1 = (lat,lon) -> System.out.printf("[Latitude: %.3f, Longitude: %.3f]%n", lat, lon);
        var firstPoint = coords.getFirst();
        ConsoleStyler.styleIntro("Playing around with BiConsumer Functional Interface ");
        processPoint(firstPoint[0], firstPoint[1], p1);
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
        int count = (names.size()/2);
        String[] randomArrayUsingLambda = new String[count];
        Supplier<Integer> supplier  = () -> new Random().nextInt(0, FIRST_NAMES.length);
        for(int i=0; i<count; i++){
            // both below are valid lambda invocations of category Supplier with use of get() implementation
            randomArrayUsingLambda[i] = FIRST_NAMES[supplier.get()]; // more readable and s is more reusable...
            //randomArrayUsingLambda[i] = FIRST_NAMES[((Supplier<Integer>) () -> new Random().nextInt(0, FIRST_NAMES.length)).get()];
        }
        ConsoleStyler.styleEachAsIs("Guest", randomArrayUsingLambda);
    }

    private static void demoPredicateLambda(List<String> names) {

        ConsoleStyler.styleIntro("Guests after remove if.... equalsIgnoreCase(\"ArjunDev\") ");
        names.removeIf(name -> name.equalsIgnoreCase("ArjunDev"));
        //names.forEach((String name) -> ConsoleStyler.styleIt(name, false));
        ConsoleStyler.styleEachAsIs("", names);
        ConsoleStyler.halfDivider();
        names.removeIf(name -> name.startsWith("Ar"));
        ConsoleStyler.styleIntro("Guests after remove if.... startsWith(\"Ar\") ");
        //names.forEach((String name) -> ConsoleStyler.styleIt(name, false));
        ConsoleStyler.styleEachAsIs("", names);

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        ConsoleStyler.styleOutput("Result (inside calculator method): ", (String) result);
        return result;
    }

    // This one uses an out of box, Java Core BinaryOperator Functional Interface
    public static <T> T anotherCalculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        ConsoleStyler.styleOutput("Result (inside anotherCalculator method): ", (String) result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}

