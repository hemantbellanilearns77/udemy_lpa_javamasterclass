package com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.lambdaintro;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.CommonUtils;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
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
  public static final ExcecutionUtil execution = new ExcecutionUtil();


    record Person (String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    private static int namesCount =  secureRandom.nextInt(1,64);
    public static void main(String[] args) {

        execution.initialize();

        Name generatedFullName = NamesUtil.generateRandomName();
        List<Person> people = new ArrayList<>(Arrays.asList(
                new LambdaIntrosMain.Person(generatedFullName.getFirstName(),generatedFullName.getLastName())));
        for(int i=0; i<namesCount; i++) {
            generatedFullName = NamesUtil.generateRandomName();
            people.add(new Person(generatedFullName.getFirstName(),generatedFullName.getLastName()));
        }
        // Using anonymous class
        var comparatorLastName = new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                return p1.firstName().compareTo(p2.firstName());
            }
        };
        //one way is this...
        // people.sort(comparatorLastName);
        ConsoleStyler.styleOutput("Sorted only one level (By First NamesUtil)");
        people.sort((Person p1, Person p2) -> p1.lastName().compareTo(p2.lastName()));
        ConsoleStyler.styleOutput(people.toString());

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.firstName().compareTo(p2.firstName());
                return (result == 0 ? secondLevel(p1, p2) : result);
            }

            @Override
            public int secondLevel(Person p1, Person p2) {
                return p1.lastName().compareTo(p2.lastName());
            }
        };
        ConsoleStyler.styleOutput("Sorted till second level (By FirstName and then Last Name)");
        people.sort(comparatorMixed);
        ConsoleStyler.styleOutput(people.toString());


        execution.finalizeExecution();
    }

  //
}
