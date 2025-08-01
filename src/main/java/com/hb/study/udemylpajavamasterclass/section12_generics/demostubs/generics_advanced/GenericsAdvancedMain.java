package com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.model.LPAStudent;
import com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.model.Student;
import com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.util.QueryItem;
import com.hb.study.udemylpajavamasterclass.section12_generics.demostubs.generics_advanced.util.QueryList;

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
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] args) {

        execution.initialize();
        int studentCount = new Random().nextInt(1,11);
        System.out.println(studentCount + " random student(s) with random details have been created for demonstration purposes".toUpperCase());
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreLists(students);
        ConsoleStyler.divider();
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreLists(lpaStudents);
        ConsoleStyler.divider();
        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));
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
//     QueryList<Employee> employeeList = new QueryList<>();
 	       /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

  //

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
