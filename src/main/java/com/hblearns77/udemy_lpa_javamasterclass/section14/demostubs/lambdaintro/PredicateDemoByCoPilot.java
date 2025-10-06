package com.hblearns77.udemy_lpa_javamasterclass.section14.demostubs.lambdaintro;

import com.hblearns77.udemy_lpa_javamasterclass.global.models.Name;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.NamesUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * created by : heman on 11-07-2025, 03:58 PM, in the "udemy_lpa_javamasterclass" project
 **/
public class PredicateDemoByCoPilot {
    public static final SecureRandom secureRandom = new SecureRandom();
    private static final ExecutionUtil execution = new ExecutionUtil();

    private static int namesCount = secureRandom.nextInt(1, 64);

    // Custom Predicate implementation
    static class StartsWithA implements Predicate<String> {
        @Override
        public boolean test(String name) {
            return name.startsWith("A");
        }
    }

        public static void main(String[] args) {
        //

        execution.initialize(args);

        List<String> names = new ArrayList<>();
        Name generatedFullName;
        ConsoleStyler.styleOutput("Original (unfiltered) name count is: " + namesCount);
        for (int i = 0; i < namesCount; i++) {
            generatedFullName = NamesUtil.generateRandomName();
            names.add(generatedFullName.getFirstName());
        }
        ConsoleStyler.styleOutput("The list of names as originally generated is: ");
        for (int i = 0; i < namesCount; i++) {
            ConsoleStyler.styleOutput("%d) %-12s%n".formatted((i + 1), names.get(i)));
        }
        ConsoleStyler.divider();

        // Pass the custom Predicate implementation
        names.removeIf(new StartsWithA());
        //or use lambda to remove names that start with 'A'
        names.removeIf(name -> name.startsWith("A"));
        namesCount = names.size();
        ConsoleStyler.styleOutput("Now (filtered) name count is: " + namesCount);

        ConsoleStyler.styleOutput("""
                The list of names as after removing the names that start with 'A' is: 
                """);
        for (int i = 0; i < namesCount; i++) {
            ConsoleStyler.styleOutput("%d) %-12s%n".formatted((i + 1), names.get(i)));
        }
        ConsoleStyler.divider();

        execution.finalizeExecution();
    }
}
