package com.hb.study.udemylpajavamasterclass.section7_oop_part1.demostubs.recordsampleproject;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class MainClass {
    public static void main(String[] args) {
        int loopCounter;

        for(loopCounter = 1; loopCounter <= 5; loopCounter++) {
            LPA_JPMStudent lpa_jpm_recordStudent = new LPA_JPMStudent(
                    "S9230" + loopCounter,
                    switch(loopCounter) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05-Nov-1985", "Java MasterClass");
            ConsoleStyler.styleOutput(lpa_jpm_recordStudent.toString());
            ConsoleStyler.styleOutput("Next id is : " + lpa_jpm_recordStudent.id());
        }

        for(loopCounter = 1; loopCounter <= 5; loopCounter++) {
            POJOStudent pojoStudent = new POJOStudent(
                    "S9230" + loopCounter,
                    switch(loopCounter) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    },
                    "05-Nov-1985", "Java MasterClass");
            ConsoleStyler.styleOutput(pojoStudent.toString());
            ConsoleStyler.styleOutput("Next id is : " + pojoStudent.getId());
        }

    }
}
