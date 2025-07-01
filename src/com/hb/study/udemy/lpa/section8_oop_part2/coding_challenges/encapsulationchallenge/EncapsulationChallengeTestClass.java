package com.hb.study.udemy.lpa.section8_oop_part2.coding_challenges.encapsulationchallenge;

public class EncapsulationChallengeTestClass {
    public static void main(String[] args) {
    /*    Printer printer = new Printer(100, true);

        printer.printPages(200);
        printer.addToner(25);*/

        Printer printer = new Printer(50, true);
        System.out.println(printer.addToner(50));
        System.out.println("initial page count = " +printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
    }
    }


