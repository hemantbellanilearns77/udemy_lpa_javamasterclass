package com.hblearns77.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

public class CompoudAssignmentOperatorChallange {
    public static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        int result = 10;
        result -= 5;
        ConsoleStyler.styleOutput("result now is : " + result);
        ConsoleStyler.styleOutput("result now is : " + result++);
        ConsoleStyler.styleOutput("result lastly is : " + result);
        execution.finalizeExecution();
    }
}
