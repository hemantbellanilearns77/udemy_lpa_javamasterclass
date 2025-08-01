package com.hb.study.udemylpajavamasterclass.section15.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * created by : heman on 30-07-2025, 07:36 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class CollectionIntro {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.startSection("""
                This class demonstratively introduces Collections framework at a very high level."""); // required
        ConsoleStyler.styleInitializationInfo("""
                A collection of first names has been initialized and
                a String Array along with
                a few other local variables"""); // optional

        ConsoleStyler.halfDivider();
        ConsoleStyler.styleIntro("Demonstrating a few basic calls on methods of Collection Interface"); // optional

        Collection<String> list = new HashSet<>();
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        ConsoleStyler.styleExecutionInsight("""
                Demonstrating basic add and addAll of elements to the Collection
                """);
        list.addAll(Arrays.asList(names));
        ConsoleStyler.styleEachAsIs("Name -> " , names);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        ConsoleStyler.styleEachAsIs("Name -> " , names);
        ConsoleStyler.styleOutput(null, """
        Gary is in the list?""" + list.contains("Gary"));
        ConsoleStyler.halfDivider();

        ConsoleStyler.styleExecutionInsight("""
                Demonstrating removeif(filter is true) of elements to the Collection
                """);
        list.removeIf(s -> s.charAt(0) == 'G');
        ConsoleStyler.styleEachAsIs("Name -> " , names);
        ConsoleStyler.styleOutput(null, """
        Gary is in the list?""" + list.contains("Gary"));

        ConsoleStyler.halfDivider();
        ConsoleStyler.styleExecutionInsight("""
                Demonstrating removeif(filter is true) of elements to the Collection
                """);

        ConsoleStyler.endSection("""
                This class demonstratively introduces Collections framework at a very high level."""); // required
        execution.finalizeExecution();
    }
}
