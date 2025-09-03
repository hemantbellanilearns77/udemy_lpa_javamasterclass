package com.hb.study.udemy_lpa_javamasterclass.section4_basics.demostubs.firstfewclasses;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Hello {
        public static void main(String[] args) {
        if(args.length>0) {
            ConsoleStyler.styleInitializationInfo("""
                    Some console arguments were supplied for processing during execution.
                    """);
        }
        ConsoleStyler.styleOutput("******** Inside Hello Class..... *********");
        ConsoleStyler.styleOutput("Hello Hemant");
    }
}
