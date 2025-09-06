package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


import java.util.Scanner;

public class TraditionalSwitchChallenge {
        public static void main(String[] ignoredUnusedArgs) {
        //
        Scanner scanner = new Scanner(System.in);
         ConsoleStyler.styleOutput("Enter an alphabet in range of A-E: ");
        char inputCharacter = scanner.nextLine().charAt(0);
        ConsoleStyler.styleOutput("The NATO Word for the character " + inputCharacter + " is: " +
                printNATOWord(inputCharacter));
    }

    private static String printNATOWord(char inputCharacter) {

        switch (inputCharacter) {
            case 'A', 'a' : return "Able";
            case 'B', 'b' : return "Baker";
            case 'C', 'c' : return "Charlie";
            case 'D', 'd' : return "Dog";
            case 'E', 'e' : return "Easy";
            default: return "not found";
        }
    }
}
