package com.hb.study.udemylpajavamasterclass.section6_controlflow.demostubs;


import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;

public class ForEachLoopExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");

        // Use a for-each loop to iterate over the ArrayList
        ConsoleStyler.styleOutput("Fruits in the list:");
        for (String fruit : fruits) {
            ConsoleStyler.styleOutput(fruit);
        }
    }
}
