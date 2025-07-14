package com.hb.study.udemylpajavamasterclass.section14.misc_practice.lambdaintro;

import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.models.Name;

import java.util.*;

/**
 * created by : heman on 11-07-2025, 11:55 AM, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaIntrosMain {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();

    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh","Arijit","Aishwarya","Anamika","Amarjot","Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    record Person (String firstName, String lastName) {

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    private static int namesCount =  new Random().nextInt(1,64);
    public static void main(String[] args) {

        execution.setUp();
        /*
         *****************************************************
         */

        Name generatedFullName = new Name(CommonUtils.generateRandomName(FIRST_NAMES,LAST_NAMES));
        List<Person> people = new ArrayList<>(Arrays.asList(
                new LambdaIntrosMain.Person(generatedFullName.getFirstName(),generatedFullName.getLastName())));
        for(int i=0; i<namesCount; i++) {
            generatedFullName = new Name(CommonUtils.generateRandomName());
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
        System.out.println("Sorted only one level (By First Names)");
        people.sort((Person p1, Person p2) -> p1.lastName().compareTo(p2.lastName()));
        System.out.println(people);

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
        System.out.println("Sorted till second level (By FirstName and then Last Name)");
        people.sort(comparatorMixed);
        System.out.println(people);

        /*

         ******************************************************
         */
        execution.windDown();
    }

  //
}
