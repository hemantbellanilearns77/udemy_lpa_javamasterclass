package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

/**
 * created by : heman on 24-07-2025, 04:02 pm, in the "Default (Template) Project" project
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ConsoleStyler.printBanner("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            ConsoleStyler.styleOutput("i = " + i);
        }
    }
}