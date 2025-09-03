package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class CompoudAssignmentOperatorChallange {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        int result = 10;
        result -= 5;
        ConsoleStyler.styleOutput("result now is : " + result);
//        ConsoleStyler.styleOutput("result now is : " + result++);
//        ConsoleStyler.styleOutput("result now is : " + result);
    }
}
