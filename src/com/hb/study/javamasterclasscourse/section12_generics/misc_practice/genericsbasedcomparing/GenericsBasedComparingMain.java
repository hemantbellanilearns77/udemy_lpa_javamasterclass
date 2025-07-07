package com.hb.study.javamasterclasscourse.section12_generics.misc_practice.genericsbasedcomparing;

import com.hb.study.javamasterclasscourse.globalcommon.constants.GlobalCommonConstants;
import com.hb.study.javamasterclasscourse.globalcommon.utils.ExcecutionUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class GenericsBasedComparingMain {

    public static void main(String[] args) {
        ExcecutionUtil excecutionUtil = new ExcecutionUtil();
        System.out.println(GlobalCommonConstants.programOutputBegins);
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
        System.out.println("A:"+(int)'A' + " " + "a:"+(int)'a');
        System.out.println("B:"+(int)'B' + " " + "b:"+(int)'b');
        System.out.println("P:"+(int)'P' + " " + "p:"+(int)'p');
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        Student tim = new Student ("Tim");
        Student [] students = {new Student("Zach"), new Student("Tim"),
                new Student("Ann"), new Student("Tim")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        System.out.println("result = " + tim.compareTo(new Student("TIM")));
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));
        System.out.println(GlobalCommonConstants.asteriskSeparatorLine);
        excecutionUtil.updateExecutionStats();
        System.out.println(excecutionUtil);
        System.out.println(GlobalCommonConstants.programOutputEnds);
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
    private static Random random = new Random();

    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
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

