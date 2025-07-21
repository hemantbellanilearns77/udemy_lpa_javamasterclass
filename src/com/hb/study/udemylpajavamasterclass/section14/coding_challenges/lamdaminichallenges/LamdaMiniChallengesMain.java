package com.hb.study.udemylpajavamasterclass.section14.coding_challenges.lamdaminichallenges;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * created by : heman on 20-07-2025, 09:45 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class LamdaMiniChallengesMain {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };
    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
    private static final int maxElementAndIterationCount = new Random().nextInt(1, (63 + 1));

    public static void main(String[] ignoredArgs) {
        execution.initialize();

        /*
         *****************************************************
         */


        //iniChallengeOne();
        miniChallengeTwo();


        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    public static void miniChallengeOne() {
        ConsoleStyler.startSection("Lambda Mini Challenge # 1 : Creating a lambda from an anonymous class....");
        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                ConsoleStyler.styleEach("Part: ", parts);
            }
        };
        String originalSentence = "I am trying to print the parts of this sentence using a Lambda Expression generated out of an anonymous class";
        ConsoleStyler.startSubSection("[INITIALIZATION]: \n" + "Original sentence : \"" + originalSentence + "\"");

        ConsoleStyler.styleIt("Original sentence divided into 'word parts' now below (using accept() call on Anonymous class : ", false, true);
        printTheParts.accept(originalSentence);
        ConsoleStyler.halfDivider();

        Consumer<String> printThePartsLambda = sentence -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            String[] sentenceParts = sentence.split(" ");
            /*
                for(String nextWord: sentenceParts) {
                    ConsoleStyler.styleIt("NextPart: "  + "[" + atomicInteger.getAndIncrement() + "] : " + nextWord, false);
            }*/
            ConsoleStyler.styleEach("Part: ", sentenceParts);

        };
        ConsoleStyler.styleIt("InitaliOriginal sentence divided into 'word parts' now below, (using accept() call on printThePartsLambda Lamda) : ",
                false, true);
        printThePartsLambda.accept(originalSentence);
        ConsoleStyler.halfDivider();

        //OR
        Consumer<String> printThePartsConcise = sentence -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Arrays.asList(sentence.split(" ")).forEach(nextWord -> ConsoleStyler.styleIt("NextWordPart" + "[" + atomicInteger.getAndIncrement() + "] : " + nextWord, false));
        };
        ConsoleStyler.styleIt("Original sentence divided into 'word parts' now below, (using accept() call on printThePartsConcise Lambda) : ",
                false, true);
        printThePartsConcise.accept(originalSentence);

        ConsoleStyler.endSection("Lambda Mini Challenge # 1 : Creating a lambda from an anonymous class (Consumer Lambda)");
    }

    public static void miniChallengeTwo() {
        ConsoleStyler.startSection("Lambda Mini Challenge # 2 : Creating a lambda from an method with return value (Function Lambda)");
        ConsoleStyler.startSubSection("Here's the method provided \n ");
        ConsoleStyler.styleInfo("""
                public static String everySecondChar(String source){
                         StringBuilder returnVal = new StringBuilder();
                         for( int i=0; i<source.length(); i++){
                             if(i%2==1){
                                 returnVal.append(source.charAt(i));
                             }
                         }
                         return returnVal.toString();
                     }
                """);

        ConsoleStyler.styleInfo("""
                 //The Lambda definition
                 Function<String, String> stringFunctionLambda = (String s) -> {
                            StringBuilder returnVal = new StringBuilder();
                            for( int i=0; i<s.length(); i++){
                                if(i%2==1){
                                    returnVal.append(s.charAt(i));
                                }
                            }
                
                            return returnVal.toString();
                        };
                 //The Lambda call
                 stringFunctionLambda.apply("The quick brown fox jumps over the lazy dog!")
                 and here's the output after lambda call:
                """);
        Function<String, String> stringFunctionLambda = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        ConsoleStyler.styleIt(stringFunctionLambda.apply("The quick brown fox jumps over the lazy dog!"), false);
        ConsoleStyler.halfDivider();

        UnaryOperator<String> unaryStringLambda = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for( int i=0; i<s.length(); i++){
                if(i%2==1){
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };
        ConsoleStyler.styleInfo("""
                ALTERNATIVELY:
                //The Lambda definition
                 UnaryOperator<String, String> unaryStringLambda = (String s) -> {
                            StringBuilder returnVal = new StringBuilder();
                            for( int i=0; i<s.length(); i++){
                                if(i%2==1){
                                    returnVal.append(s.charAt(i));
                                }
                            }
                
                            return returnVal.toString();
                        };
                 //The Lambda call
                 unaryStringLambda.apply("The quick brown fox jumps over the lazy dog!")
                  and here's the output after lambda call:
                """);
        ConsoleStyler.styleIt(unaryStringLambda.apply("The quick brown fox jumps over the lazy dog!"), false);
        ConsoleStyler.halfDivider();
        UnaryOperator<String> unaryOperatorConcise = (String s) -> {
            return everySecondChar(s);
        };

        ConsoleStyler.styleInfo("""
                ALTERNATIVELY:
                UnaryOperator<String> unaryOperatorConcise = (String s) -> {
                            return everySecondChar(s);
                        };                 
                 //The Lambda call
                 unaryOperatorConcise.apply("The quick brown fox jumps over the lazy dog!")
                  and here's the output after lambda call:
                """);
        ConsoleStyler.styleIt(unaryOperatorConcise.apply("The quick brown fox jumps over the lazy dog!"), false);
        ConsoleStyler.endSection("Lambda Mini Challenge # 2 : Creating a lambda from an method with return value (Function Lambda)");

    }
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }
    /*public static void demoFunction() {
        ConsoleStyler.startSection("Demonstration of XYZ Concept....");
        ConsoleStyler.startSubSection("Subsection 1.... ");
        ConsoleStyler.halfDivider();
        ConsoleStyler.startSubSection("Subsection 2.... ");
        ConsoleStyler.endSection("Demonstration of XYZ Concept....");
    }*/

}
