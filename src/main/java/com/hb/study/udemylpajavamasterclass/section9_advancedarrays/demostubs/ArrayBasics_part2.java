package com.hb.study.udemylpajavamasterclass.section9_advancedarrays.demostubs;


public class ArrayBasics_part2 {

    public static void main(String... args) {
        String asteriskSeparatorLine = "*".repeat(153) + "\n";
        String programOutputBegins = "*".repeat(63) + " The Output of " + ArrayBasics_part2.class.getSimpleName() + " is as below " + "*".repeat(63);
        System.out.println(programOutputBegins);
        String[] textList = "Hello World Again".split(" ");
        printText(textList);
        System.out.println(asteriskSeparatorLine);
        String [] testStringArray = {"Test1", "Test2","Test3", "Test4","Test5"};
        System.out.println(String.join("; ", testStringArray));
        System.out.println(asteriskSeparatorLine);
    }
    private static void printText(String[] textList){
        for(String stringElement: textList){
            System.out.println(stringElement);
        }
    }
}
