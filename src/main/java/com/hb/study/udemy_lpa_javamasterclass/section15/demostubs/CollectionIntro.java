package com.hb.study.udemy_lpa_javamasterclass.section15.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * created by : heman on 30-07-2025, 07:36 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CollectionIntro {

    //Object level or Static declarations here...
    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        ConsoleStyler.startSection("This class demonstratively introduces Collections framework at a very high level."); // required
        ConsoleStyler.styleInitializationInfo("""
                A collection of first names has been initialized and
                a String Array along with
                a few other local variables"""); // optional
        final String LABELPREFIX_NAME = "Name -> ";
        final String GARY = "Gary";
        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Demonstrating a few basic calls on methods of Collection Interface"); // optional

        Collection<String> list = new HashSet<>();
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        ConsoleStyler.styleExecutionInsight("""
                Demonstrating basic add and addAll of elements to the Collection
                """);
        list.addAll(Arrays.asList(names));
        ConsoleStyler.styleEachAsIs(LABELPREFIX_NAME , names);

        list.add("Fred");
        list.addAll(Arrays.asList("George", GARY, "Grace"));
        ConsoleStyler.styleEachAsIs(LABELPREFIX_NAME , names);
        ConsoleStyler.styleOutput(null, """
        Gary is in the list?""" + list.contains(GARY));
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleExecutionInsight("Demonstrating removeif(filter is true) of elements to the Collection");
        list.removeIf(s -> s.charAt(0) == 'G');
        ConsoleStyler.styleEachAsIs(LABELPREFIX_NAME , names);
        ConsoleStyler.styleOutput(null, """
        Gary is in the list?""" + list.contains(GARY));

        ConsoleStyler.halfDivider();
        ConsoleStyler.styleExecutionInsight("Demonstrating removeif(filter is true) of elements to the Collection");

        ConsoleStyler.endSection("This class demonstratively introduces Collections framework at a very high level."); // required
        execution.finalizeExecution();
    }
}
