package com.hb.study.udemylpajavamasterclass.section15.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemylpajavamasterclass.section15.setup.Card;

import java.util.List;
import java.util.Random;

/**
 * created by : heman on 31-07-2025, 08:51 pm, in the "run-sonar-scan-admin.bat" project
 **/
public class DemoCardSetup {

    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final int maxElementAndIterationCount = new Random().nextInt(1, (63 + 1));

    public static void main(String[] ignoredArgs) {
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
