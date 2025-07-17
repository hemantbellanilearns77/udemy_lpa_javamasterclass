package com.hb.study.udemylpajavamasterclass.global.utils;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;

/**
 * created by : heman on 16-07-2025, 01:09 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class ConsoleStyler {

    //Object level or Static declarations here...
    //public static ExcecutionUtil execution = new ExcecutionUtil();

   /* public static void main(String[] ignoredArgs) {
        execution.setUp();

        *//*
         *****************************************************
         *//*

        //your code for main method goes in here

        *//*
         *****************************************************
         *//*
        execution.windDown();
    }*/
   // Prints a bannered header
   public static void printBanner(String title) {
       System.out.println(CommonConstants.SECTION_SEPARATOR);
       System.out.println("📌 " + title.toUpperCase());
       System.out.println(CommonConstants.SECTION_SEPARATOR);
   }
    public static void startSection(String label) {
        System.out.println(CommonConstants.SECTION_SEPARATOR);
        System.out.println("🔷 START: " + label.toUpperCase());
        System.out.println(CommonConstants.DOTTED_LINE);
    }

    public static void endSection(String label) {
        System.out.println(CommonConstants.DOTTED_LINE);
        System.out.println("🏁 END: " + label.toUpperCase());
        System.out.println(CommonConstants.SECTION_SEPARATOR);
    }

    public static void divider() {
        System.out.println(CommonConstants.ASTERISKSEPERATORLINESTRFULL);
    }

    public static void styleIt(String styleStr) {
        System.out.println(styleStr);
    }
}
