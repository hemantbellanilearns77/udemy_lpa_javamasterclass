package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.model.LPAStudent;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.model.Student;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.util.QueryItem;
import com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.util.QueryList;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class GenericsAdvancedMain {
    //Object level or Static declarations here...
    public static final ExcecutionUtil execution = new ExcecutionUtil();
    public static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] ignoredUnusedArgs) {

        execution.initialize();
        int studentCount = secureRandom.nextInt(1, 11);
        ConsoleStyler.styleOutput(studentCount + " random student(s) with random details have been created for demonstration purposes".toUpperCase());
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printList(students);
        printMoreLists(students);
        ConsoleStyler.divider();
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
        printMoreLists(lpaStudents);
        ConsoleStyler.divider();
        List<String> namesList = new ArrayList<>(List.of("Able", "Barry", "Charlie"));
        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3));
        testList(namesList);
        testList(numberList);
        anotherTestList(namesList);
        oneMoreestList(numberList);
        ConsoleStyler.divider();
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches(
                "Course", "Python");
        printMoreLists(matches);
        ConsoleStyler.divider();
        var students2021 =
                QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);
        ConsoleStyler.divider();
        execution.finalizeExecution();
    }

    public static void printMoreLists(List<? extends Student> students) {
        if (students.isEmpty()) {
            ConsoleStyler.styleOutput("Empty List....  Nothing to print.... ");
            return;
        }
        for (var student : students) {
            ConsoleStyler.styleOutput(student.toString());
        }
        ConsoleStyler.styleOutput(students.toString());
    }

    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                ConsoleStyler.styleOutput("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                ConsoleStyler.styleOutput("Integer: " + i.floatValue());
            }
        }
    }

    public static void anotherTestList(List<String> list) {

        for (var element : list) {
            ConsoleStyler.styleOutput("String: " + element.toUpperCase());
        }
    }

    public static void oneMoreestList(List<Integer> list) {

        for (var element : list) {
            ConsoleStyler.styleOutput("Integer: " + element.floatValue());
        }
    }

    public static <T extends Student> void printList(List<T> students) {

        for (var student : students) {
            ConsoleStyler.styleOutput(student.getYearStarted() + ": " + student);
        }
        ConsoleStyler.divider();
    }
}
