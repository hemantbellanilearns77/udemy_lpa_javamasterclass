package com.hb.study.demo_stubs;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.*;
public class RandomNumberOddEven {
    public static void main(String[] args) {
        Integer randomInteger = new Random().nextInt(1, 100);
        ConsoleStyler.styleOutput("RandomInteger is: " + randomInteger);
        if ((randomInteger % 2) != 0) {
            ConsoleStyler.styleOutput("RandomInteger is ODD ");
        } else {
            ConsoleStyler.styleOutput("RandomInteger is EVEN ");
        }
    }
}
