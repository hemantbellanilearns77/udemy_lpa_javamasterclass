package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

//SmartKitchenControlCenterApp
public class SKCCApp {

    private static final ExecutionUtil execution = new ExecutionUtil();

    public static void main(String[] args) {
        execution.initialize(args);
        SmartKitchen smartKitchen = new SmartKitchen();
        smartKitchen.getBrewMaster().brewCoffee();
        smartKitchen.getDishWasher().doDishes();
        smartKitchen.getIceBox().orderFood();
        smartKitchen.loadDishWasher();



        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
        execution.finalizeExecution();
    }
}
