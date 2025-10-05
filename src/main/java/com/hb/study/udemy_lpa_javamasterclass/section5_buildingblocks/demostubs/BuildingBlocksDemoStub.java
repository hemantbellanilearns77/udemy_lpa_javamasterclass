package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;


public class BuildingBlocksDemoStub {
    private static final ExecutionUtil execution = new ExecutionUtil();
    public static void main(String[] args) {
        execution.initialize(args);
        int myVariable = 50; // a valid java statement
        myVariable++;
        myVariable--;
        ConsoleStyler.styleOutput("Value of myVariable: " + myVariable);
        execution.finalizeExecution();
    }
}
