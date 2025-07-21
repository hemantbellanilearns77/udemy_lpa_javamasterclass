package com.hb.study.udemylpajavamasterclass.section14.coding_challenges.lamdaminichallenges;

import com.hb.study.udemylpajavamasterclass.global.models.SemanticColorRole;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;
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
        miniChallengeOne();
        miniChallengeTwoThroughFive();
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
        ConsoleStyler.startSubSection("Original sentence divided into 'word parts' using accept() call on printThePartsLambda Lambda is as below: ");
        printThePartsLambda.accept(originalSentence);
        ConsoleStyler.halfDivider();

        //OR
        Consumer<String> printThePartsConcise = sentence -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Arrays.asList(sentence.split(" ")).forEach(nextWord -> ConsoleStyler.styleIt("NextWordPart" + "[" + atomicInteger.getAndIncrement() + "] : " + nextWord));
        };
        ConsoleStyler.startSubSection("Original sentence divided into 'word parts' now below, (using accept() call on printThePartsConcise Lambda) : ");
        printThePartsConcise.accept(originalSentence);

        ConsoleStyler.endSection("Lambda Mini Challenge # 1 : Creating a lambda from an anonymous class (Consumer Lambda)");
    }

    public static void miniChallengeTwoThroughFive() {
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
        ConsoleStyler.startSubSection(""" 
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
        ConsoleStyler.styleSubSectionInfo("""
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
                 and here's the output after lambda call:
                """ + stringFunctionLambda.apply("The quick brown fox jumps over the lazy dog!"));

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
        ConsoleStyler.styleSubSectionInfo("""
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
        ConsoleStyler.styleIt("Here's the output after lambda call:\n"
        + unaryStringLambda.apply("The quick brown fox jumps over the lazy dog!"));

ConsoleStyler.halfDivider();

UnaryOperator<String> unaryOperatorConcise = (String s) -> {
    return everySecondChar(s);
};
ConsoleStyler.styleSubSectionInfo("""
                Alternatively, we can create a Lambda Expression based on a concise definition of UnaryOperator<String, String> ( Lambda Function )
                UnaryOperator<String> unaryOperatorConcise = (String s) -> {
                            return everySecondChar(s);
                        };
                 //The Lambda call
                 unaryOperatorConcise.apply("The quick brown fox jumps over the lazy dog!")
                """);

        ConsoleStyler.styleIt("Here's the output after lambda call:\n"
                + unaryOperatorConcise.apply("The quick brown fox jumps over the lazy dog!"));
        ConsoleStyler.halfDivider();
        ConsoleStyler.startSubSection("""
                Mini Challenge # 4 & 5: ALTERNATIVELY: We can define a TARGET FUNCTION that accepts the Lambda Expression,
                which in turn is defined using UnaryOperator<String, String> ( Lambda Function ) and then invoke it...
                """);

        String result = everySecondChar(unaryOperatorConcise, "The quick brown fox jumps over the lazy dog!");
        ConsoleStyler.styleIt("""
                Here's the definition of that Target Function: an overloaded version of everySecondChar
                public static String everySecondChar(Function<String,String> function, String source ){
                    return function.apply(source);
                }
                // Then invoked it, with source string
                result = everySecondChar.apply(unaryOperatorConcise, "The quick brown fox jumps over the lazy dog!");
                and here's the output after lambda call:\n
                """ + result, SemanticColorRole.SUBSECTION_ITALIC_INFO,false);
        ConsoleStyler.endSection("Lambda Mini Challenge # 2,3,4,5 : Function Lambda variations");
    }

    public static void miniChallengeSixSevenEight() {
        ConsoleStyler.startSection("Lambda Mini Challenge # 6,7,8 : Supplier Lambda variations");
        ConsoleStyler.endSection("Lambda Mini Challenge # 6,7,8 : Supplier Lambda variations");
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
    /*public static void demoFunction() {
        ConsoleStyler.startSection("Demonstration of XYZ Concept....");
        ConsoleStyler.startSubSection("Subsection 1.... ");
        ConsoleStyler.halfDivider();
        ConsoleStyler.startSubSection("Subsection 2.... ");
        ConsoleStyler.endSection("Demonstration of XYZ Concept....");
    }*/

}
