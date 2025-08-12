package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.exercises.exercise35;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class MainClass_execrise35 {

    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        ConsoleStyler.styleOutput("one.real= " + one.getReal());
        ConsoleStyler.styleOutput("one.imaginary= " + one.getImaginary());
        one.subtract(number);
        ConsoleStyler.styleOutput("one.real= " + one.getReal());
        ConsoleStyler.styleOutput("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        ConsoleStyler.styleOutput("number.real= " + number.getReal());
        ConsoleStyler.styleOutput("number.imaginary= " + number.getImaginary());
    }
}
