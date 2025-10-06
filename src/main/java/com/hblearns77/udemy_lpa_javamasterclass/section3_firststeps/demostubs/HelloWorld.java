package com.hblearns77.udemy_lpa_javamasterclass.section3_firststeps.demostubs;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.logging.Logger;

public class HelloWorld {
    public static final Logger logger = Logger.getLogger("HelloWorld");
    public static void main(String [] args) {

        String userName = args[0].concat(" " + args[1]);
        ConsoleStyler.styleOutput("********** Inside Hello World Class **********");
        ConsoleStyler.styleOutput(" How are you, dear Mr./Mrs. " + userName + " ?");
    }
}
