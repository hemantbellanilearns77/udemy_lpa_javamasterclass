package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaadvanced;

import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        Lambda Function Applied: (a, b) -> 'T' + (value1 * value2)
        Final Result from calculator:  """ + result, true, true);

        //Lambda invocation using anotherCalculator i.e. the BinaryOperator Functional Interface...
        int anotherResult = anotherCalculator((a, b) ->  (value1 * value2), value1, value2);
        ConsoleStyler.styleIt("""
        Lambda Function Applied: (a, b) -> 'T' + (value1 * value2)
        Final Result from anotherCalculator:  """ + anotherResult, true, true);
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
}

/*
package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaadvanced;

import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * created by : heman on 11-07-2025, 06:11 PM, in the "udemy_lpa_javamasterclass" project
 **//*

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
        int loopCounter;
        */
/*
 *****************************************************
 *//*


        List<String> names = new ArrayList<>();

        Name generatedFullName;
        System.out.println("Original (unfiltered) name count is: " + namesCount);
        for (loopCounter = 0; loopCounter < namesCount; loopCounter++) {
            generatedFullName = new Name(CommonUtils.generateRandomName(FIRST_NAMES, LAST_NAMES));
            names.add(generatedFullName.getFirstName());
        }
        System.out.println("The list of names as originally generated is shown below using forEach (lambda version): ");
       */
/* for(int i=0; i<namesCount; i++) {
            System.out.printf("%d) %-12s%n", (i+1),names.get(i));
        }*//*

        //AtomicInteger lambdaLoopCounter = new AtomicInteger(1);
        // looping a list using lambda expression
        //names.forEach(nextName -> System.out.printf("[%d] %-12s%n", (lambdaLoopCounter.getAndIncrement()), nextName));
        ConsoleStyler.styleEach("Guest", names);
        ConsoleStyler.divider();
        final int value1 = 7;
        final int value2 = 9;

        int result = calculator((a, b) -> 'T' + (value1 * value2), value1, 9);

        */
        /* variations of the above lambda call
         int result = calculator((Integer v1, Integer v2) -> {
            return 'T' + (value1 * value2);
        }, value1, value2); // using final variables to be utilized
        int result = calculator((a,b) -> 'T' + (a*b), 7,9);
        int result = calculator((var a, var b) -> 'T' + (a*b), 7,9); // using var as return types
        int result = calculator((Integer a, Integer b) -> 'T' + (a*b), 7,9); explicit return types
        int result = calculator((a,b) -> {int c = a*b; return c;}, 7,9); // using return ad curly braces
         *//*

        //ConsoleStyler.styleIt("Result is: " + result);
        System.out.println("Result is: " + result);
        */
/*

 ******************************************************
 *//*

        execution.finalizeExecution();
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result (inside calculator method): " + result);
        return result;
    }

    //
}
*/