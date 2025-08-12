package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.allaboutstrings;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class StringVsStringBuilderDemo {
    public static void main(String[] args) {
        String stringObject = "Hello" + " World";
        //StringBuilder stringBuilderObject  = "Hello" + " World"; // Sample error - as StringBuilder cannot be initialized by String literals...

        StringBuilder stringBuilderObject  = new StringBuilder("Hello World");
        stringObject.concat(" and Goodbye...");
        stringBuilderObject.append(" and Goodbye..... ");
        printInformation(stringObject);
        printInformation(stringBuilderObject);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(57));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));
        printInformation(emptyStart);
        printInformation(emptyStart32);
        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");

        ConsoleStyler.styleOutput("************************************************************************************************");
        ConsoleStyler.styleOutput("**** Some Method calls on StringBuilder ****");

        builderPlus.deleteCharAt(16).insert(16, 'g');
        ConsoleStyler.styleOutput(builderPlus.toString());
        builderPlus.replace(16, 17, "G");
        ConsoleStyler.styleOutput(builderPlus.toString());
        builderPlus.reverse().setLength(7);
        ConsoleStyler.styleOutput(builderPlus.reverse().toString());
    }
    public static void printInformation(String stringObj) {
        ConsoleStyler.styleOutput("The String that's needed to be printed is: " + stringObj);
        ConsoleStyler.styleOutput("The length of String that's needed to be printed is: " + stringObj.length());
        ConsoleStyler.styleOutput("************************************************************************************************");

    }
    public static void printInformation (StringBuilder stringBuilder){
        ConsoleStyler.styleOutput("The StringBuilder that's needed to be printed is: " + stringBuilder);
        ConsoleStyler.styleOutput("The length of StringBuilder that's needed to be printed is: " + stringBuilder.length());
        ConsoleStyler.styleOutput("The Capacity of StringBuilder that's needed to be printed is:" + stringBuilder.capacity());

        ConsoleStyler.styleOutput("************************************************************************************************");

    }



}
