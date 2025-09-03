package com.hb.study.udemy_lpa_javamasterclass.section9_advancedarrays.demostubs;


import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ArrayBasics_part2 {

    public static void main(String... ignoredUnusedArgs) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(63) + " The Output of " + ArrayBasics_part2.class.getSimpleName() + " is as below " + "*".repeat(63);
        ConsoleStyler.styleOutput(programOutputBegins);
        String[] textList = "Hello World Again".split(" ");
        printText(textList);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
        String [] testStringArray = {"Test1", "Test2","Test3", "Test4","Test5"};
        ConsoleStyler.styleOutput(String.join("; ", testStringArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
    }
    private static void printText(String[] textList){
        for(String stringElement: textList){
            ConsoleStyler.styleOutput(stringElement);
        }
    }
}
