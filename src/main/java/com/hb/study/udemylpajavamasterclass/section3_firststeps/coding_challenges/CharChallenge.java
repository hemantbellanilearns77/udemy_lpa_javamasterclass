package com.hb.study.udemylpajavamasterclass.section3_firststeps.coding_challenges;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class CharChallenge {
    public static void main(String[] args) {
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63;

    ConsoleStyler.styleOutput("My Char values are: \n\n 1. mySimpleChar: \'" + mySimpleChar + "\'" +
            "\n 2. myUnicodeChar: \'" + myUnicodeChar + "\'" +
            "\n 3. myDecimalChar: \'" + myDecimalChar + "\'");
    }
}
