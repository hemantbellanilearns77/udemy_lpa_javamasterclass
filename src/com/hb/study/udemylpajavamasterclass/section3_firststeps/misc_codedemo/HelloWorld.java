package com.hb.study.udemylpajavamasterclass.section3_firststeps.misc_codedemo;

public class HelloWorld {
    public static void main(String [] args) {

        String userName = args[0].concat(" " + args[1]);
        System.out.print("********** Inside Hello World Class **********");
        System.out.println(" How are you, dear Mr./Mrs. " + userName + " ?");
    }
}
