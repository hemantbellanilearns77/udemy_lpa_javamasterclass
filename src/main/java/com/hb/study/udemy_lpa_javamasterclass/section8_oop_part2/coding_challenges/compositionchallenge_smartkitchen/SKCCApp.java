package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.compositionchallenge_smartkitchen;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

//SmartKitchenControlCenterApp
public class SKCCApp {

        public static void main(String[] ignoredUnusedArgs) {
        //
        SmartKitchen smartKitchen = new SmartKitchen();

        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
    }
}
