package com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.model.*;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.coding_challenges.finalgenericschallenge.util.*;

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


        public static void main(String[] ignoredUnusedArgs) {

        execution.initialize();

        QueryList<LPAStudent> queryList = new QueryList<>();
        int maxStudents = 25;
        LPAStudent newLPAStudent;
        for(int loopCounter = 1; loopCounter<=maxStudents; loopCounter++) {
                newLPAStudent = new LPAStudent();
                queryList.add(newLPAStudent);
        }
        ConsoleStyler.styleOutput(maxStudents + " random student(s) with random details have been created for demonstration purposes:".toUpperCase());
        printList(queryList);
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);
        ConsoleStyler.divider();

        ConsoleStyler.styleOutput("Matches");
        QueryList<LPAStudent> anotherQueryList = new QueryList<>(queryList
                .getMatches("PercentComplete", "50"));
        var matches = QueryList.getMatches(anotherQueryList, "Course", "Python");

        matches.sort(new LPAStudentComparator());
        printList(matches);
        ConsoleStyler.divider();

        ConsoleStyler.styleOutput("Ordered");
        matches.sort(null);
        printList(matches);

        ConsoleStyler.divider();
//     QueryList<Employee> employeeList = new QueryList<>();

        execution.finalizeExecution();
    }

    public static void printList(List<?> students) {

        for (var student : students) {
            ConsoleStyler.styleOutput(student.toString());
        }
    }
}
