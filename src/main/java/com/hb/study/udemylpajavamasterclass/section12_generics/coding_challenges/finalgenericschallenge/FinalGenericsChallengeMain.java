package com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.finalgenericschallenge;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.finalgenericschallenge.model.*;
import com.hb.study.udemylpajavamasterclass.section12_generics.coding_challenges.finalgenericschallenge.util.*;

import java.util.Comparator;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
public class FinalGenericsChallengeMain {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] args) {
        execution.initialize();

        QueryList<LPAStudent> queryList = new QueryList<LPAStudent>();
        int maxStudents = 25;
        for(int loopCounter = 1; loopCounter<=maxStudents; loopCounter++) {
                queryList.add(new LPAStudent());
        }
        System.out.println(maxStudents + " random student(s) with random details have been created for demonstration purposes:".toUpperCase());
        printList(queryList);
        ConsoleStyler.divider();
        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);
        ConsoleStyler.divider();

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                .getMatches("Course", "Python");

        matches.sort(new LPAStudentComparator());
        printList(matches);
        ConsoleStyler.divider();

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches);

        ConsoleStyler.divider();
//     QueryList<Employee> employeeList = new QueryList<>();
        /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

  //

    public static void printList(List<?> students) {

        for (var student : students) {
            System.out.println(student);
        }
    }
}
