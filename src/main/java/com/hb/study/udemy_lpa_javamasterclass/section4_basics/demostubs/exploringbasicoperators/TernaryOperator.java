package com.hb.study.udemy_lpa_javamasterclass.section4_basics.demostubs.exploringbasicoperators;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class TernaryOperator {
        public static void main(String[] ignoredUnusedArgs) {
        //
        ConsoleStyler.styleOutput("******** Inside TernaryOperator Class..... *********");
        String makeOfCar = "Volkswagen";

        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true ;
        if(isDomestic) {
            ConsoleStyler.styleOutput("This car is domestic to our country");
        } else {
            ConsoleStyler.styleOutput("This car is domestic to our country");
        }

    }
}
