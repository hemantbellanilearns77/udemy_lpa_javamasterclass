package com.hb.study.udemy_lpa_javamasterclass.section15.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.section15.setup.Card;

import java.util.List;

/**
 * created by : heman on 31-07-2025, 08:51 pm, in the "run-sonar-scan-admin.bat" project
 **/
public class DemoCardSetup {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
     

    public static void main(String[] ignoredunusedArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
        // main method initializations.... 
        /*
         *****************************************************
         */
        //your own code here; recommended to divide in function calls
        demoFunction();
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    public static void demoFunction() {
        List<Card> deck;
        deck = Card.getStandardDeck();
        Card.printDeck(deck);
    }
}
