package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class miscellaneous {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        int myVariable = 50; // a valid java statement
        myVariable++;
        myVariable--;
        ConsoleStyler.styleOutput("Value of myVariable: " + myVariable);
    }
}
