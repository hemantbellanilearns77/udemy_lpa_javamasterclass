package com.hb.study.udemy_lpa_javamasterclass.section7_oop_part1.demostubs.recordsampleproject;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class RecordsDemoMainClass {
        private static final ExecutionUtil execution = new ExecutionUtil();
        public static void main(String[] args) {
        execution.initialize(args);
        int loopCounter;

        for(loopCounter = 1; loopCounter <= 5; loopCounter++) {
            LPAJPMStudent lpa_jpm_recordStudent = new LPAJPMStudent(
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
        execution.finalizeExecution();
    }
}
