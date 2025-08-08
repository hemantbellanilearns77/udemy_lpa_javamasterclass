package com.hb.study.udemylpajavamasterclass.section8_oop_part2.exercises.exercise39;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        ConsoleStyler.styleOutput(printer.addToner(50)  + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput("initial page count = " +printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
    }
}
