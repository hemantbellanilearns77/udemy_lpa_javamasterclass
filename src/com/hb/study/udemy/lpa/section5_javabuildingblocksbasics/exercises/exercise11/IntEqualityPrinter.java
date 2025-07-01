package com.hb.study.udemy.lpa.section5_javabuildingblocksbasics.exercises.exercise11;

public class IntEqualityPrinter {
    public static void main(String[] args) {
          /*
        *   printEqual(1, 1, 1); should print text All numbers are equal

            printEqual(1, 1, 2); should print text Neither all are equal or different

            printEqual(-1, -1, -1); should print text Invalid Value

            printEqual(1, 2, 3); should print text All numbers are different
        * */
        System.out.println("printEqual(1, 1, 1) : ");  printEqual(1, 1, 1);
        System.out.println("printEqual(1, 1, 2) : ");  printEqual(1, 1, 2);
        System.out.println("printEqual(-1, -1, -1) : ");  printEqual(-1, -1, -1);
        System.out.println("printEqual(1, 2, 3) : ");  printEqual(1, 2,3);
    }

    public static void printEqual(int first, int second, int third) {
        if( (first < 0 ) || (second < 0) || ( third < 0 ) ) {
            System.out.println("Invalid Value");
            return;
        } else if( (first == second ) && (second == third)) {
            System.out.println("All numbers are equal");
            return;
        } else {
            if( (first != second ) && ( first != third ) && ( second != third) ) {
                System.out.println("All numbers are different");
                return;
            } else {
                System.out.println("Neither all are equal or different");
                return;
            }
        }
    }
}
