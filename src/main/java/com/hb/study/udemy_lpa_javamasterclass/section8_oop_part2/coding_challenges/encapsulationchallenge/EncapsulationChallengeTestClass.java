package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.encapsulationchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class EncapsulationChallengeTestClass {
        public static void main(String[] args) {

        Printer printer = new Printer(100, true);

        printer.printPages(200);
        printer.addToner(25);

        Printer anotherPrinter = new Printer(50, true);
        ConsoleStyler.styleOutput(printer.addToner(50) + "");
        ConsoleStyler.styleOutput("initial page count = " + anotherPrinter.getPagesPrinted());
        int pagesPrinted = anotherPrinter.printPages(4);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " + anotherPrinter.getPagesPrinted());
        pagesPrinted = anotherPrinter.printPages(2);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " + anotherPrinter.getPagesPrinted());
        }
    }


