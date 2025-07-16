package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaintro;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * created by : heman on 11-07-2025, 03:58 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class PredicateDemoByCoPilot {
    private static ExcecutionUtil execution = new ExcecutionUtil();
    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh","Arijit","Aishwarya","Anamika","Amarjot","Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };
    private static int namesCount =  new Random().nextInt(1,64);
    // Custom Predicate implementation
    static class StartsWithA implements Predicate<String> {
        @Override
        public boolean test(String name) {
            return name.startsWith("A");
        }
    }
    public static void main(String[] args) {

        execution.setUp();
        /*
         *****************************************************
         */
        List<String> names = new ArrayList<>();
        Name generatedFullName;
        System.out.println("Original (unfiltered) name count is: " + namesCount);
        for(int i = 0; i < namesCount; i++) {
            generatedFullName = new Name(CommonUtils.generateRandomName());
            names.add(generatedFullName.getFirstName());
        }
        System.out.println("The list of names as originally generated is: ");
        for(int i=0; i<namesCount; i++) {
            System.out.printf("%d) %-12s%n", (i+1),names.get(i));
        }
        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTRFULL);

        // Pass the custom Predicate implementation
        //names.removeIf(new StartsWithA());
        //or use lambda to remove names that start with 'A'
        names.removeIf(name -> name.startsWith("A"));
        namesCount = names.size();
        System.out.println("Now (filtered) name count is: " + namesCount);

        System.out.println("The list of names as after removing the names that start with \'A\' is: ");
        for(int i=0; i<namesCount; i++) {
            System.out.printf("%d) %-12s%n", (i+1),names.get(i));
        }
        System.out.print(CommonConstants.ASTERISKSEPERATORLINESTRFULL);

        /*

         ******************************************************
         */
        execution.windDown();
    }
}
