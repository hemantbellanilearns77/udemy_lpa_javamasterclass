package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise31;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Exercise41_MainClass {

    private static final String FULL_NAME = "fullName= ";

        public static void main(String[] ignoredUnusedArgs) {
        //
        Person person = new Person();
        person.setFirstName("");   // firstName is set to empty string
        person.setLastName("");    // lastName is set to empty string
        person.setAge(10);
        ConsoleStyler.styleOutput(FULL_NAME + person.getFullName());
        ConsoleStyler.styleOutput("teen= " + person.isTeen());
        person.setFirstName("John");    // firstName is set to John
        person.setAge(18);
        ConsoleStyler.styleOutput(FULL_NAME + person.getFullName());
        ConsoleStyler.styleOutput("teen= " + person.isTeen());
        person.setLastName("Smith");    // lastName is set to Smith
        ConsoleStyler.styleOutput(FULL_NAME + person.getFullName());

    }
}
