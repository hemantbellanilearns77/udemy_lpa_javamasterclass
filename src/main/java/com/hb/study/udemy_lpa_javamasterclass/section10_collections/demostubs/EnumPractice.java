package com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class EnumPractice {
    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

        ConsoleStyler.styleOutput("Days of the week are: \n" +
                Arrays.asList(DayOfTheWeek.values()));
        ConsoleStyler.divider();

        DayOfTheWeek weekDay = getRandomDay();
        ConsoleStyler.styleOutput("Randomly generated Random Day is: " + weekDay);
        ConsoleStyler.divider();


        long loopCounterLimit = new SecureRandom().nextLong(1, (4294967296L / new SecureRandom().nextLong(1, 4294967296L)));
        long loopCounter = 0;
        long weekendDaysFound = 0;
        for (; loopCounter < loopCounterLimit; loopCounter++) {
            weekDay = getRandomDay();
            System.out.printf(loopCounter + " Name is: %s, Ordinal Value is: %d%n",
                    weekDay.name(), weekDay.ordinal());
            switch (weekDay) {
                case FRIDAY, SATURDAY, SUNDAY -> weekendDaysFound++;
            }
            if ((weekDay == DayOfTheWeek.FRIDAY) || (weekDay == DayOfTheWeek.SATURDAY) || (weekDay == DayOfTheWeek.SUNDAY)) {
                weekendDaysFound++;
            }
        }
        ConsoleStyler.styleOutput("Total of " + ((loopCounter == 1) ? 0 : loopCounter) + " iterations were executed... ");
        long weekendDaysPercentage = Math.round(((double) weekendDaysFound / (double) loopCounter) * 100);
        ConsoleStyler.styleOutput("A total of " + weekendDaysFound + " Weekend Days were found and that's approximately " + weekendDaysPercentage + " %");

        execution.finalizeExecution();
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(0, 7);
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }
}
