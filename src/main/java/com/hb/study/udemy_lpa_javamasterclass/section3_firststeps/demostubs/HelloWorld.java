package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class HelloWorld {
    public static void main(String [] args) {

        String userName = args[0].concat(" " + args[1]);
        System.out.print("********** Inside Hello World Class **********");
        ConsoleStyler.styleOutput(" How are you, dear Mr./Mrs. " + userName + " ?");
    }
}
