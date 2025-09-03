package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.exercises.exercise13;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Scanner;

public class NumberInWord {
        public static void main(String[] ignoredUnusedArgs) {
        //
        Scanner scanner = new Scanner(System.in);
        ConsoleStyler.styleOutput("Enter a whole number: ");
        int number = scanner.nextInt();
        printNumberInWord(number);
    }

    public static void printNumberInWord (int number) {
        switch(number) {
            case 0 ->  ConsoleStyler.styleOutput("ZERO");
            case 1 -> ConsoleStyler.styleOutput("ONE");
            case 2 -> ConsoleStyler.styleOutput("TWO");
            case 3 -> ConsoleStyler.styleOutput("THREE");
            case 4 -> ConsoleStyler.styleOutput("FOUR");
            case 5 -> ConsoleStyler.styleOutput("FIVE");
            case 6 -> ConsoleStyler.styleOutput("SIX");
            case 7 -> ConsoleStyler.styleOutput("SEVEN");
            case 8 -> ConsoleStyler.styleOutput("EIGHT");
            case 9 -> ConsoleStyler.styleOutput("NINE");
            default -> ConsoleStyler.styleOutput("OTHER");
        }
    }
}
