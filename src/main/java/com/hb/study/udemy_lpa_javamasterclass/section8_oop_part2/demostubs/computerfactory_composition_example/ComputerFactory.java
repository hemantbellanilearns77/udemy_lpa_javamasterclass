package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class ComputerFactory {
        public static void main(String[] unusedArgs) {
        //
        ComputerCase theCase = new ComputerCase("2208", "Dell", "240" );
        Monitor theMonitor = new Monitor("27-inch Beast", "Acer", 27, "2540 x 1440" );
        Motherboard theMotherboard = new Motherboard("BJ-220", "Asus", 4, 6 , "v2.44");

        PersonalComputer thePC = new PersonalComputer("2208","Dell",
                theCase, theMonitor,theMotherboard);
       /* thePC.getComputerCase().pressPowerButton();
        thePC.getMotherboard().loadProgram("Operating System");
        thePC.getMonitor().drawPixelAt(35, 35, "blue");*/
        ConsoleStyler.styleOutput("Your PC has these configurations : \n " + thePC);
        ConsoleStyler.styleOutput("************************************************************************************************");
        thePC.powerUp();

    }
}
