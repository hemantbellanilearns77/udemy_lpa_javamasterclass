package com.hb.study.udemy_lpa_javamasterclass.section4_basics.demostubs.exploringbasicoperators;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.Arrays;

public class TernaryOperator {
        public static void main(String[] args) {
            if(args!= null && args.length>0) {
                ConsoleStyler.styleExecutionInsight("args as supplied are: " + Arrays.toString(args));
            }
        ConsoleStyler.styleOutput("******** Inside TernaryOperator Class..... *********");
        String makeOfCar = "Volkswagen";
        ConsoleStyler.styleExecutionInsight("""
                Was:
                boolean isDomestic = !makeOfCar.equals("Volkswagen");
                if(isDomestic) {
                    ConsoleStyler.styleOutput("This car is domestic to our country");
                } else {
                    ConsoleStyler.styleOutput("This car is domestic to our country");
                }
                Modified to make code sonar friendly
                """);

            ConsoleStyler.styleOutput("This car of make: " + makeOfCar + " is domestic to our country");

        }
}
