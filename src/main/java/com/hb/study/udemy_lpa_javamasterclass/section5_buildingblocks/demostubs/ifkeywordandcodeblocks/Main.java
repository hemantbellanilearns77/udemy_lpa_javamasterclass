package com.hb.study.udemy_lpa_javamasterclass.section5_buildingblocks.demostubs.ifkeywordandcodeblocks;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Main {
        public static void main(String[] ignoredUnusedArgs) {
        //

        ConsoleStyler.styleOutput("Inside InterfaceChallengeMainClass Method ... Before invoking the method");
        testMethodReturnWithoutValue();
        ConsoleStyler.styleOutput("After returning back from testMethodReturnWithoutValue");

    }

    public static void testMethodReturnWithoutValue() {
        ConsoleStyler.styleOutput("Number of declared methods is: " + Main.class.getClass().getMethods().length);
     /*   for(int counter = 0; counter < 150; counter++) {
           // if("testMethodReturnWithoutValue".equalsIgnoreCase(InterfaceChallengeMainClass.class.getClass().getDeclaredMethods()[counter].toString()))
                ConsoleStyler.styleOutput("Inside Method : " + InterfaceChallengeMainClass.class.getClass().getDeclaredMethods()[counter]);
        }*/
        ConsoleStyler.styleOutput("Inside testMethodReturnWithoutValue method, just before returning back to main");
        return;
    }
}
