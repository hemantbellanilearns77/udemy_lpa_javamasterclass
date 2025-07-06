package com.hb.study.javamasterclasscourse.section7_oop_part1.misc_practice.allaboutstrings;

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

        System.out.println("************************************************************************************************");
        System.out.println("**** Some Method calls on StringBuilder ****");

        builderPlus.deleteCharAt(16).insert(16, 'g');
        System.out.println(builderPlus);
        builderPlus.replace(16, 17, "G");
        System.out.println(builderPlus);
        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus.reverse());
    }
    public static void printInformation(String stringObj) {
        System.out.println("The String that's needed to be printed is: " + stringObj);
        System.out.println("The length of String that's needed to be printed is: " + stringObj.length());
        System.out.println("************************************************************************************************");

    }
    public static void printInformation (StringBuilder stringBuilder){
        System.out.println("The StringBuilder that's needed to be printed is: " + stringBuilder);
        System.out.println("The length of StringBuilder that's needed to be printed is: " + stringBuilder.length());
        System.out.println("The Capacity of StringBuilder that's needed to be printed is:" + stringBuilder.capacity());

        System.out.println("************************************************************************************************");

    }



}
