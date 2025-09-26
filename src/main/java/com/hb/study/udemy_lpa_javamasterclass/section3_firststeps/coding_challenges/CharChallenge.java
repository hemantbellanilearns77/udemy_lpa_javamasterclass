package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.coding_challenges;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
public class CharChallenge {
        public static void main(String[] args) {
        //
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63;

    ConsoleStyler.styleOutput("My Char values are: \nCommonConstants.NEWLINE 1. mySimpleChar: \'" + mySimpleChar + "\'" +
            "CommonConstants.NEWLINE 2. myUnicodeChar: \'" + myUnicodeChar + "\'" +
            "CommonConstants.NEWLINE 3. myDecimalChar: \'" + myDecimalChar + "\'");
    }
}
