package com.hb.study.udemylpajavamasterclass.section14.misc_codedemo.lambdaadvanced;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.models.Name;
import com.hb.study.udemylpajavamasterclass.global.utils.CommonUtils;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by : heman on 11-07-2025, 06:11 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class LambdaAdvancedDemo {
    private static ExcecutionUtil execution = new ExcecutionUtil();
    private static final String[] FIRST_NAMES = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh", "Arijit", "Aishwarya", "Anamika", "Amarjot", "Amritpal"
    };

    private static final String[] LAST_NAMES = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    private static final int namesCount = new Random().nextInt(1, 64);

    public static void main(String[] args) {

        execution.setUp();
        int loopCounter;
        /*
         *****************************************************
         */

        List<String> names = new ArrayList<>();

        Name generatedFullName;
        System.out.println("Original (unfiltered) name count is: " + namesCount);
        for (loopCounter = 0; loopCounter < namesCount; loopCounter++) {
            generatedFullName = new Name(CommonUtils.generateRandomName(FIRST_NAMES, LAST_NAMES));
            names.add(generatedFullName.getFirstName());
        }
        System.out.println("The list of names as originally generated is shown below using forEach (lambda version): ");
       /* for(int i=0; i<namesCount; i++) {
            System.out.printf("%d) %-12s%n", (i+1),names.get(i));
        }*/
        AtomicInteger lambdaLoopCounter = new AtomicInteger(1);
        // looping a list using lambda expression
        names.forEach(nextName -> System.out.printf("[%d] %-12s%n", (lambdaLoopCounter.getAndIncrement()), nextName));
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);


        /*

         ******************************************************
         */
        execution.windDown();
    }

    //
}
