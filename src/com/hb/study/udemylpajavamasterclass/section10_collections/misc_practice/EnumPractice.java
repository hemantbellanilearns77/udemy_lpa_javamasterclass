package com.hb.study.udemylpajavamasterclass.section10_collections.misc_practice;


import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.Random;

public class EnumPractice {
    //Object level or Static declarations here...
    public static ExcecutionUtil execution = executionSetup();
    public static void main(String[] args) {
        // Set Start time
        //long startTime = System.nanoTime();
        //executionTiming.setStartTime(System.nanoTime());
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
/*        System.out.println("Days of the week are: \n" +
                Arrays.asList(DayOfTheWeek.values()));
        System.out.println(asteriskSeparatorLine);

        DayOfTheWeek weekDay = getRandomDay();
        System.out.println("Randomly generated Random Day is: " + weekDay);
        System.out.println(asteriskSeparatorLine);*/


        //long loopCounterLimit = new Random().nextLong(4294967296L);     //(Integer.MAX_VALUE-Integer.MIN_VALUE) + 1)
        long loopCounterLimit = new Random().nextLong(1, (4294967296L / new Random().nextLong(1,4294967296L)));
        long loopCounter = 0;
        long weekendDaysFound = 0;
        for(; loopCounter < loopCounterLimit; loopCounter++) {
           DayOfTheWeek weekDay = getRandomDay();
            System.out.printf(loopCounter + " Name is: %s, Ordinal Value is: %d%n",
                    weekDay.name(), weekDay.ordinal() );
            switch(weekDay){
                case FRIDAY, SATURDAY, SUNDAY -> weekendDaysFound++;
            }
           /* if((weekDay == DayOfTheWeek.FRIDAY) || (weekDay == DayOfTheWeek.SATURDAY) || (weekDay == DayOfTheWeek.SUNDAY)){
                weekendDaysFound++;
            }*/
        }
        System.out.println("Total of " + ((loopCounter == 1) ? 0 : loopCounter)  + " iterations were executed... ");
        long weekendDaysPercentage = Math.round( ((double) weekendDaysFound/ (double) loopCounter) * 100);
        System.out.println("A total of " + weekendDaysFound + " Weekend Days were found and that's approximately " + weekendDaysPercentage + " %") ;
        // Set End time
        //long endTime = System.nanoTime();
        //executionTiming.setEndTime(System.nanoTime());
        /*

         ******************************************************
         */
        execution.executionWindDown();
    }

    public static ExcecutionUtil executionSetup() {
        ExcecutionUtil executionUtil = new ExcecutionUtil();
        System.out.println(CommonConstants.EXECUTIONSETUPSSTR);
        return executionUtil;
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(0, 7);
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }


}
