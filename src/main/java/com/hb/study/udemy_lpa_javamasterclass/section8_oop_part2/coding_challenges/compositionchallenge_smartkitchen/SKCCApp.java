package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

//SmartKitchenControlCenterApp
public class SKCCApp {

    public static void main(String[] args) {
        SmartKitchen smartKitchen = new SmartKitchen();

        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
    }
}
