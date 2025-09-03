package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise39;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Main {
        public static void main(String[] ignoredUnusedArgs) {

        Printer printer = new Printer(50, true);
        ConsoleStyler.styleOutput(printer.addToner(50)  + CommonConstants.EMPTYSTRING);
        ConsoleStyler.styleOutput("initial page count = " +printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        ConsoleStyler.styleOutput("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
    }
}
