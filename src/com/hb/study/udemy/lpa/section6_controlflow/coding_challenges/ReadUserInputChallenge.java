package com.hb.study.udemy.lpa.section6_controlflow.coding_challenges;

import java.util.Scanner;

public class ReadUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int countOfIntegers = 0;
        int sum = 0;
        int nextNumber = -1;
        String nextNumberInput = "";

        while(countOfIntegers < 5) {
            System.out.println("Enter a Integer # " + (countOfIntegers+1) + " : ");
            nextNumberInput = scanner.nextLine();
            nextNumber = isValidInteger(nextNumberInput) ? Integer.parseInt(nextNumberInput)  : -1;
            if(nextNumber == -1) {
                continue;
            } else {
                sum += nextNumber;
                countOfIntegers++;
            }
        }
        System.out.println("The sum of " + countOfIntegers + " integers as input above is : " + sum);
    }
    public static boolean isValidInteger(String nextNumberInput){

        boolean isValidInt = true;

        try {
            int nextNumber = Integer.parseInt(nextNumberInput);
        } catch(NumberFormatException numberFormatException){
            System.out.println("Invalid Input");
            isValidInt = false;
            return isValidInt;
        }
        return isValidInt;
    }
}
