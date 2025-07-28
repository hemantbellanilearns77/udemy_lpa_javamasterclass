package com.hb.study.common;
import java.util.*;
public class RandomNumberOddEven {
    public static void main(String[] args) {
        Integer randomInteger = new Random().nextInt(1, 100);
        System.out.println("RandomInteger is: " + randomInteger);
        if ((randomInteger % 2) != 0) {
            System.out.println("RandomInteger is ODD ");
        } else {
            System.out.println("RandomInteger is EVEN ");
        }
    }
}
