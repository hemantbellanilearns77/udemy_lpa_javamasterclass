package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.genericsbasedcomparing;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;

public class GenericsBasedComparingMain {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {

        execution.initialize(args);

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};
        String comparisonValSymbol;

        for (Integer i : others) {
            int val = five.compareTo(i);
            comparisonValSymbol = val < 0 ? "<" : ">";
            ConsoleStyler.styleOutput("%d %s %d: compareTo=%d%n".formatted(five,
                    (val == 0 ? "==" : comparisonValSymbol), i, val));
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        ConsoleStyler.divider();
        for (String s : fruit) {
            int val = banana.compareTo(s);
            comparisonValSymbol = val < 0 ? "<" : ">";
            ConsoleStyler.styleOutput("%s %s %s: compareTo=%d%n".formatted(banana,
                    (val == 0 ? "==" : comparisonValSymbol), s, val));
        }

        Arrays.sort(fruit);
        ConsoleStyler.styleOutput(Arrays.toString(fruit));
        ConsoleStyler.styleOutput("A:" + (int) 'A' + " " + "a:" + (int) 'a');
        ConsoleStyler.styleOutput("B:" + (int) 'B' + " " + "b:" + (int) 'b');
        ConsoleStyler.styleOutput("P:" + (int) 'P' + " " + "p:" + (int) 'p');
        ConsoleStyler.divider();
        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann"), new Student("Tim")};

        Arrays.sort(students);
        ConsoleStyler.styleOutput(Arrays.toString(students));
        ConsoleStyler.styleOutput("result = " + tim.compareTo(new Student("TIM")));
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        ConsoleStyler.styleOutput(Arrays.toString(students));
        ConsoleStyler.divider();
        ConsoleStyler.styleExecutionInsight("""
                In this program, i had also been taught or thought of below implementation of CompareTo
                //    @Override
                //    public int compareTo(Object o) {
                //        Student other = (Student) o;
                //        return name.compareTo(other.name);
                //    }
                """);

        execution.finalizeExecution();
    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static final SecureRandom secureRandom = new SecureRandom();

    String name;
    private final int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = secureRandom.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {

        ConsoleStyler.styleOutput("""
                This is what was intended to be demonsrrated, but now commented to fix sonar issue:
                 return Integer.valueOf(id).compareTo(o.id);
                """);
        return Integer.compare(id, o.id);
    }
}

