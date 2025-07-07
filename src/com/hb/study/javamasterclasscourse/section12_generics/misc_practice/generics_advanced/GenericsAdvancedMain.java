package com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_advanced;

import com.hb.study.javamasterclasscourse.globalcommon.constants.GlobalCommonConstants;
import com.hb.study.javamasterclasscourse.globalcommon.utils.ExcecutionUtil;
import com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_advanced.model.LPAStudent;
import com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_advanced.model.Student;
import com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_advanced.util.QueryItem;
import com.hb.study.javamasterclasscourse.section12_generics.misc_practice.generics_advanced.util.QueryList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
public class GenericsAdvancedMain {

    public static void main(String[] args) {
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        System.out.println(GlobalCommonConstants.programOutputBegins);
        int studentCount = new Random().nextInt(1,11);
        System.out.println(studentCount + " random student(s) with random details have been created for demonstration purposes".toUpperCase());
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreLists(students);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreLists(lpaStudents);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches(
                "Course", "Python");
        printMoreLists(matches);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        var students2021 =
                QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
//     QueryList<Employee> employeeList = new QueryList<>();
        excecutionUtil.updateExecutionStats();
        System.out.println(excecutionUtil);
        System.out.println(GlobalCommonConstants.programOutputEnds);
    }

    public static void printMoreLists(List<? extends Student> students) {
        if(students.size() == 0) {
            System.out.println("Empty List....  Nothing to print.... ");
            return;
        }
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

//    public static void testList(List<String> list) {
//
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//
//        for (var element : list) {
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students) {
//
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }
}
