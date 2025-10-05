package com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.lambdaintro;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.util.*;

/**
 * created by : heman on 11-07-2025, 11:55 AM, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaIntrosMain {
    public static final SecureRandom secureRandom = new SecureRandom();
    //Object level or Static declarations here...
    public static final ExecutionUtil execution = new ExecutionUtil();


    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    private static final int MAX_CHARS_IN_NAME = secureRandom.nextInt(1, 64);

    public static void main(String[] args) {


        execution.initialize(args);

        Name generatedFullName = NamesUtil.generateRandomName();
        List<Person> people = new ArrayList<>(List.of(
                new Person(generatedFullName.getFirstName(), generatedFullName.getLastName())));
        for (int i = 0; i < MAX_CHARS_IN_NAME; i++) {
            generatedFullName = NamesUtil.generateRandomName();
            people.add(new Person(generatedFullName.getFirstName(), generatedFullName.getLastName()));
        }
        Comparator<Person> comparatorLastName = Comparator.comparing(Person::firstName);

        //one way is this...
        people.sort(comparatorLastName);
        ConsoleStyler.styleOutput("Sorted only one level (By First NamesUtil)");
        people.sort(Comparator.comparing(Person::lastName));

        ConsoleStyler.styleOutput(people.toString());

        interface EnhancedComparator<T> extends Comparator<T> {
        }

        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.firstName().compareTo(p2.firstName());
                return (result != 0 ? result : secondLevel(p1, p2));
            }

            private int secondLevel(Person p1, Person p2) {
                return p1.lastName().compareTo(p2.lastName());
            }
        };
        comparatorMixed.secondLevel(people.get(0), people.get(1));
        ConsoleStyler.styleOutput("Sorted till second level (By FirstName and then Last Name)");
        people.sort(comparatorMixed);
        ConsoleStyler.styleOutput(people.toString());
        ConsoleStyler.styleOutput("Checking secondary comparison manually:");
        int diff = comparatorMixed.secondLevel(people.get(0), people.get(1));
        ConsoleStyler.styleOutput("Secondary compare result: " + diff);


        execution.finalizeExecution();
    }
}
