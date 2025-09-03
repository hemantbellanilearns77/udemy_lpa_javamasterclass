package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class PracticeSwitch {
        public static void main(String[] unusedArgs) {
        //
        int switchValue = 7;
      //Traditional Switch
        switch (switchValue) {
            case 1:
                ConsoleStyler.styleOutput("Was 1");
                break;
            case 2,5,7:
                ConsoleStyler.styleOutput("Was 2 or 5 or 7");
                break;
            default:
                ConsoleStyler.styleOutput("Was not 1 or 2");
                break;
        }
    }
}
