package com.hb.study.udemylpajavamasterclass.section5_buildingblocks.misc_codedemo.ifkeywordandcodeblocks;

public class Main {
    public static void main(String[] args) {

        System.out.println("Inside InterfaceChallengeMainClass Method ... Before invoking the method");
        testMethodReturnWithoutValue();
        System.out.println("After returning back from testMethodReturnWithoutValue");

    }

    public static void testMethodReturnWithoutValue() {
        System.out.println("Number of declared methods is: " + Main.class.getClass().getMethods().length);
     /*   for(int counter = 0; counter < 150; counter++) {
           // if("testMethodReturnWithoutValue".equalsIgnoreCase(InterfaceChallengeMainClass.class.getClass().getDeclaredMethods()[counter].toString()))
                System.out.println("Inside Method : " + InterfaceChallengeMainClass.class.getClass().getDeclaredMethods()[counter]);
        }*/
        System.out.println("Inside testMethodReturnWithoutValue method, just before returning back to main");
        return;
    }
}
