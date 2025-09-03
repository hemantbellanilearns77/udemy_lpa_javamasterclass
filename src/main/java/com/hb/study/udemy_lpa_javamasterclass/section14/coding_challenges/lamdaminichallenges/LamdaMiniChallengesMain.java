package com.hb.study.udemy_lpa_javamasterclass.section14.coding_challenges.lamdaminichallenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
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
    private static final String QUICKBROWNFOX_SENTENCE = "The quick brown fox jumps over the lazy dog!";
    private static final String OUTPUT_AFTER_LAMBDA_CALL = "Here's the output after lambda call:";


    public static void main(String[] ignoredunusedArgs) {
        execution.initialize();

        /*
         *****************************************************
         */
        miniChallengeOne();
        miniChallengeTwoToFive();
        miniChallengeSixAndSeven();
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
                ConsoleStyler.styleEachAsIs("Part: ", parts);
            }
        };
        String originalSentence = "I am trying to print the parts of this sentence using a Lambda Expression generated out of an anonymous class";
        ConsoleStyler.styleInitializationInfo("[INITIALIZATION]: \n" + "Original sentence is: \n\"" + originalSentence + "\"");
        ConsoleStyler.halfDivider();
        ConsoleStyler.startSection("Original sentence after being divided into 'word parts' using accept() call on Anonymous class is as below: ");
        printTheParts.accept(originalSentence);
        ConsoleStyler.halfDivider();

        Consumer<String> printThePartsLambda = sentence -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            String[] sentenceParts = sentence.split(" ");
            /*
                for(String nextWord: sentenceParts) {
                    ConsoleStyler.styleIt("NextPart: "  + "[" + atomicInteger.getAndIncrement() + "] : " + nextWord, false);
            }*/
            ConsoleStyler.styleEachAsIs("Part: ", sentenceParts);

        };
        ConsoleStyler.styleIntro("Original sentence divided into 'word parts' using accept() call on printThePartsLambda Lambda is as below: ");
        printThePartsLambda.accept(originalSentence);
        ConsoleStyler.halfDivider();

        //OR
        Consumer<String> printThePartsConcise = sentence -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Arrays.asList(sentence.split(" ")).forEach(nextWord -> ConsoleStyler.styleOutput(null, "NextWordPart" + "[" + atomicInteger.getAndIncrement() + "] : " + nextWord));
        };
        ConsoleStyler.styleIntro("Original sentence divided into 'word parts' now below, (using accept() call on printThePartsConcise Lambda) : ");
        printThePartsConcise.accept(originalSentence);

        ConsoleStyler.endSection("Lambda Mini Challenge # 1 : Creating a lambda from an anonymous class (Consumer Lambda)");
    }

    public static void miniChallengeTwoToFive() {
        ConsoleStyler.startSection("Lambda Mini Challenge # 2,3,4,5 : Function Lambda variations");
        ConsoleStyler.styleInitializationInfo("""
                These 4 mini-challenges are all about creating a lambda from a method with return value 
                Also create a Target Function, using one of the variations as its arguments and demonstrate it's invocation
                Here's the method provided \n
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
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro(""" 
                Mini Challenge 2, 3: Create Lambda Expressions using the method provided above, and execute the same.""");
        Function<String, String> stringFunctionLambda = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        ConsoleStyler.styleExecutionInsight("""
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
                stringFunctionLambda.apply("The quick brown fox jumps over the lazy dog!");
                """);
        ConsoleStyler.styleOutput("""
                    Here's the output after lambda call")
                """, stringFunctionLambda.apply(QUICKBROWNFOX_SENTENCE));
        ConsoleStyler.halfDivider();

        UnaryOperator<String> unaryStringLambda = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        ConsoleStyler.styleExecutionInsight("""
                Alternatively, we can use UnaryOperator<String, String> Lambda Function based Lambda Expression
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
                 unaryStringLambda.apply("The quick brown fox jumps over the lazy dog!");
                """);
        ConsoleStyler.styleOutput(OUTPUT_AFTER_LAMBDA_CALL
                , unaryStringLambda.apply(QUICKBROWNFOX_SENTENCE));

        ConsoleStyler.halfDivider();

        UnaryOperator<String> unaryOperatorConcise = (String s) -> {
            return everySecondChar(s);
        };
        ConsoleStyler.styleExecutionInsight("""
                Alternatively, we can create a Lambda Expression based on a concise definition of UnaryOperator<String, String> ( Lambda Function )
                UnaryOperator<String> unaryOperatorConcise = (String s) -> {
                            return everySecondChar(s);
                        };
                 //The Lambda call
                 unaryOperatorConcise.apply("The quick brown fox jumps over the lazy dog!")
                """);

        ConsoleStyler.styleOutput(OUTPUT_AFTER_LAMBDA_CALL
                , unaryOperatorConcise.apply(QUICKBROWNFOX_SENTENCE));
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("""
                Mini Challenge # 4 & 5: ALTERNATIVELY: We can define a TARGET FUNCTION that accepts the Lambda Expression,
                which in turn is defined using UnaryOperator<String, String> ( Lambda Function ) and then invoke it...
                """);

        String result = everySecondChar(unaryOperatorConcise, QUICKBROWNFOX_SENTENCE);
        ConsoleStyler.styleExecutionInsight("""
                Here's the definition of that Target Function: an overloaded version of everySecondChar
                public static String everySecondChar(Function<String,String> function, String source ){
                    return function.apply(source);
                }
                // Then invoked it, with source string
                result = everySecondChar.apply(unaryOperatorConcise, "The quick brown fox jumps over the lazy dog!");                
                """);
        ConsoleStyler.styleOutput(OUTPUT_AFTER_LAMBDA_CALL, result);
        ConsoleStyler.endSection("Lambda Mini Challenge # 2,3,4,5 : Function Lambda variations");
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondChar(Function<String, String> function, String source) {
        return function.apply(source);
    }

    private static void miniChallengeSixAndSeven() {

        ConsoleStyler.startSection("Mini Challenge 6 and 7: Supplier Interface");

        ConsoleStyler.styleInitializationInfo("""
                The objective is to create a supplier of string "I Love Java"
                 amd to use it to assign to a variable supplierResult and print the same"""); // optional

        Supplier<String> iLoveJava = () -> ("I Love Java");
        Supplier<String> iLoveJava2 = () -> {
            return "I Love Java";
        };

        ConsoleStyler.styleExecutionInsight("""
                The below code was used :
                 Supplier<String> iLoveJava = () -> ("I Love Java");
                 Supplier<String> iLoveJava2 = () -> {return "I Love Java";};
                 String supplierResult = iLoveJava.get();
                 supplierResult = iLoveJava2.get();
                 ConsoleStyler.styleOutput("String iLoveJava and iLoveJava2 were initialized using Supplier<String>.get() to: " ,
                                 iLoveJava.get() + " and " + iLoveJava2.get() );
                """); // optional
        String supplierResult = iLoveJava.get();

        ConsoleStyler.styleOutput("String iLoveJava was initialized using Supplier<String>.get() to: ",
                supplierResult);
        supplierResult = iLoveJava2.get();
        ConsoleStyler.styleOutput("String iLoveJava was initialized using Supplier<String>.get() to: ",
                supplierResult);
        ConsoleStyler.halfDivider();
        ConsoleStyler.endSection("Mini Challenge 6 and 7: Supplier Interface");

    }

}
