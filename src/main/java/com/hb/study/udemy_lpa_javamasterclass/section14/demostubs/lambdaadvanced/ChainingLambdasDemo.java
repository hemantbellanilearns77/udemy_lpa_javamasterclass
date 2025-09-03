package com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.lambdaadvanced;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * created by : heman on 28-07-2025, 10:05 am, in the "udemy_lpa_javamasterclass" project
 **/
public class ChainingLambdasDemo {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String BUCHALKA = "Buchalka";
    private static final String S_S_FORMATSPEC_ONE = """
            %s %s""";
    private static final String LAMNDACHAINING_DEMO_SECTIONLABEL = """
    Demonstration of use of chaining of Lambda calls and Comparing (Chained Sorting)""";

    public static void main(String[] ignoredignoredUnusedArgs) {
        execution.initialize();
        //your own code here; recommended to divide in function calls
        demoChainingLmbdasANDComparing();
        execution.finalizeExecution();
    }

    public static void demoChainingLmbdasANDComparing() {
        ConsoleStyler.startSection(LAMNDACHAINING_DEMO_SECTIONLABEL); // required
        ConsoleStyler.styleIntro("""
                This section firstly demonstrates how to leverage convenience methods,
                on some of the Functional Interfaces that Java provides out-of-box.
                and thereafter, it demonstrates how to leverage static convenience methods for enhancing sorting.
                available from the "Comparator" Functional Interfaces that Java provides out-of-box.
                These are default methods on functional interfaces
                """);
        ConsoleStyler.styleInitializationInfo("Only a few Strings were initialized right before their usage in demo");

        String name = "Tim";
        Function<String,String> uCase = String::toUpperCase;
        ConsoleStyler.styleOutput(null ,uCase.apply(name));

        Function<String,String> lastName = s -> s.concat(" " + BUCHALKA);
        Function<String,String> uCaseLastName = uCase.andThen(lastName);

        ConsoleStyler.styleOutput(null ,uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        ConsoleStyler.styleOutput(null ,uCaseLastName.apply(name));

        Function<String,String[]> f0 = uCase
                .andThen(s -> s.concat(" " + BUCHALKA))
                .andThen(s -> s.split(" "));
        ConsoleStyler.styleOutput(null ,Arrays.toString(f0.apply(name)));

        Function<String,String> f1 = uCase
                .andThen(s -> s.concat(" " + BUCHALKA))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        ConsoleStyler.styleOutput(null ,f1.apply(name));

        Function<String,Integer> f2 = uCase
                .andThen(s -> s.concat(" " + BUCHALKA))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        ConsoleStyler.styleOutput(null ,Integer.toString(f2.apply(name)));

        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen(s-> System.out.print(" - "))
                .andThen(s1));

        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);
        ConsoleStyler.styleOutput(null ,"combined1 = " + combined1.test(name));

        Predicate<String> combined2 = p3.and(p4);
        ConsoleStyler.styleOutput(null ,"combined2 = " + combined2.test(name));

        Predicate<String> combined3 = p3.and(p4).negate();
        ConsoleStyler.styleOutput(null ,"combined3 = " + combined3.test(name));


        ConsoleStyler.halfDivider();
        record Person(String firstName, String lastName) {
        }

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(s -> ConsoleStyler.styleOutput(null ,
                S_S_FORMATSPEC_ONE.formatted(s.firstName(),  s.lastName() ) ));

        ConsoleStyler.halfDivider();
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(s -> ConsoleStyler.styleOutput(null ,
                S_S_FORMATSPEC_ONE.formatted(s.firstName(),  s.lastName() ) ));
        ConsoleStyler.halfDivider();
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(s -> ConsoleStyler.styleOutput(null ,
                S_S_FORMATSPEC_ONE.formatted(s.firstName(),  s.lastName() ) ));

        ConsoleStyler.halfDivider();
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(s -> ConsoleStyler.styleOutput(null ,
                S_S_FORMATSPEC_ONE.formatted(s.firstName(),  s.lastName() ) ));

        ConsoleStyler.endSection(LAMNDACHAINING_DEMO_SECTIONLABEL); // required
        ConsoleStyler.divider();
    }


}
