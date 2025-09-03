package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.logging.Logger;

public class HelloWorld {
    public static final Logger logger = Logger.getLogger("HelloWorld");
    public static void main(String [] ignoredUnusedArgs) {

        String userName = ignoredUnusedArgs[0].concat(" " + ignoredUnusedArgs[1]);
        ConsoleStyler.styleOutput("********** Inside Hello World Class **********");
        ConsoleStyler.styleOutput(" How are you, dear Mr./Mrs. " + userName + " ?");
    }
}
