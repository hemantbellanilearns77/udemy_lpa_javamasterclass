package com.hb.study.udemy_lpa_javamasterclass.section14.demostubs.lambdaintro;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * created by : heman on 11-07-2025, 04:41 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class FunkyFilters {
  //Object level or Static declarations here...
  public static final ExcecutionUtil execution = new ExcecutionUtil();
  public static final SecureRandom  secureRandom = new SecureRandom();

    private static int namesCount =  secureRandom.nextInt(1,64);

    public static void main(String[] ignoredArgs) {

        execution.initialize();
        List<String> names = new ArrayList<>();
        Name generatedFullName = NamesUtil.generateRandomName();

        ConsoleStyler.styleOutput("Original (unfiltered) name count is: " + namesCount);
        for(int i = 0; i<namesCount; i++) {
            names.add(generatedFullName.getFirstName());
        }
        ConsoleStyler.styleOutput("The list of names as originally generated is: ");
        for(int i=0; i<namesCount; i++) {
            ConsoleStyler.styleOutput("%d) %-12s%n".formatted((i+1),names.get(i)));
        }
        ConsoleStyler.divider();

        // Predicate: starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Predicate: name length > 5
        Predicate<String> longerThanFive = name -> name.length() > 5;

        // Combined Predicate: starts with 'C' AND longer than 5 characters
        Predicate<String> funkyFilter = startsWithA.and(longerThanFive);

        names.removeIf(funkyFilter);
        namesCount = names.size();
        ConsoleStyler.styleOutput("Now (filtered) name count is: " + namesCount);

        ConsoleStyler.styleOutput("The list of names as after removing the names that start with 'A' and having length greater than 5 is: ");
        for(int i=0; i<namesCount; i++) {
            ConsoleStyler.styleOutput("%d) %-12s%n".formatted((i+1),names.get(i)));
        }
        // Apply filter and print matching names
        names.stream()
                .filter(funkyFilter)
                .forEach(ConsoleStyler::styleOutput); // Output: Charlie
        execution.finalizeExecution();
    }
}
