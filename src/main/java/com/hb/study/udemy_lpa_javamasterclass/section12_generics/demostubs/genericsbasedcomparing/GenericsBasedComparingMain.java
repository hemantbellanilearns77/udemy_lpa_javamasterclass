package com.hb.study.udemy_lpa_javamasterclass.section12_generics.demostubs.genericsbasedcomparing;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class GenericsBasedComparingMain {
    //Object level or Static declarations here...
  public static ExcecutionUtil execution = new ExcecutionUtil();

    public static void main(String[] args) {
        execution.initialize();

        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        ConsoleStyler.divider();
        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruit);
        ConsoleStyler.styleOutput(Arrays.toString(fruit));
        ConsoleStyler.styleOutput("A:"+(int)'A' + " " + "a:"+(int)'a');
        ConsoleStyler.styleOutput("B:"+(int)'B' + " " + "b:"+(int)'b');
        ConsoleStyler.styleOutput("P:"+(int)'P' + " " + "p:"+(int)'p');
        ConsoleStyler.divider();
        Student tim = new Student ("Tim");
        Student [] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann"), new Student("Tim")};

        Arrays.sort(students);
        ConsoleStyler.styleOutput(Arrays.toString(students));
        ConsoleStyler.styleOutput("result = " + tim.compareTo(new Student("TIM")));
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        ConsoleStyler.styleOutput(Arrays.toString(students));
        ConsoleStyler.divider();
 	       /*

         ******************************************************
         */
        execution.finalizeExecution();
    }

  //
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
    private int id;
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
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
}

