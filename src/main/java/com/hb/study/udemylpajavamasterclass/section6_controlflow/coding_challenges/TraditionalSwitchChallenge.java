package com.hb.study.udemylpajavamasterclass.section6_controlflow.coding_challenges;

import java.util.Scanner;

public class TraditionalSwitchChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an alphabet in range of A-E: ");
        char inputCharacter = scanner.nextLine().charAt(0);
        System.out.println("The NATO Word for the character " + inputCharacter + " is: " +
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
