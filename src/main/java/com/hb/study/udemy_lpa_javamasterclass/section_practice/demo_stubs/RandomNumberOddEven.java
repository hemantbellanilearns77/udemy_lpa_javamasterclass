package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;

public class RandomNumberOddEven {
    public static final SecureRandom secureRandom = new SecureRandom();
        public static void main(String[] args) {

        int randomInteger = secureRandom.nextInt(1, 100);
        ConsoleStyler.styleOutput("RandomInteger is: " + randomInteger);
        if ((randomInteger % 2) != 0) {
            ConsoleStyler.styleOutput("RandomInteger is ODD ");
        } else {
            ConsoleStyler.styleOutput("RandomInteger is EVEN ");
        }
    }
}
