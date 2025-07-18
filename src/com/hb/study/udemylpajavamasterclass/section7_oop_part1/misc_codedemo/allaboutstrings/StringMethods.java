package com.hb.study.udemylpajavamasterclass.section7_oop_part1.misc_codedemo.allaboutstrings;

import java.util.Locale;

public class StringMethods {

    public static void main(String[] args) {
       /*  for(int i = 1, j=1; i <= 100000; i*=10){
            System.out.printf("Printing %6d %n",i);
        }*/
        String stringToInspect  = "Hello World";
        String stringToInspectToLower  = stringToInspect.toLowerCase(Locale.ROOT);

        //String inspection methods : length / isempty / charAt
        printInformation(stringToInspect);
        printInformation("");
        printInformation("\t      \n");
        //String comarison methods : compare, equals etc...
        printStringComparisonResults(stringToInspect, stringToInspectToLower);
        // String Manipulation Methods. - substring etc....
        demoStringManipulation();
    }

    /*
        This methods uses :  String inspection methods : length / isempty / charAt to print information about the String argument passed
     */
    public static void printInformation (String stringToInspect){
        System.out.println("String supplied in printInformation as String to inspect is: " + stringToInspect);
        System.out.println("The length of String to Inspect is: " + stringToInspect.length());
        if(stringToInspect.isEmpty()) {
            System.out.println("String is Enpty (contains whitespace characters only!)");
            System.out.println("************************************************************************************************");
        } else {
            if(stringToInspect.isBlank()) {
                System.out.println("String: " + stringToInspect + " is Blank!");
            }
            if(stringToInspect.equalsIgnoreCase("Hello World")) {
        System.out.println("****************************************************************************************************************************");
                System.out.println("The character at 7th index of String : " + stringToInspect + " is: " + stringToInspect.charAt(7) );
                System.out.printf("The first character and last character in %s are %c and %c respectively %n", stringToInspect, stringToInspect.charAt(0),
                        stringToInspect.charAt(stringToInspect.length()-1));
                System.out.println("****************************************************************************************************************************");
                System.out.printf("Index of character: 'r' in string : \"%s\", is: %d %n", stringToInspect, stringToInspect.indexOf('r') );
        System.out.println("****************************************************************************************************************************");
                System.out.printf("Index of string: \"World\" in string : \"%s\", is: %d %n", stringToInspect, stringToInspect.indexOf("World") );
        System.out.println("****************************************************************************************************************************");
        System.out.println("****************************************************************************************************************************");
                System.out.printf("Index of character: 'l' in string : \"%s\", is: %d %n", stringToInspect, stringToInspect.indexOf('l'));
                System.out.printf("Last Index of character: 'l' in string : \"%s\", is: %d %n", stringToInspect, stringToInspect.lastIndexOf('l'));
                System.out.printf("Index of character: 'l' after its first occurrence  in string : \"%s\", is: %d %n", stringToInspect,
                        stringToInspect.indexOf('l', (stringToInspect.indexOf('l') + 1) ));
                System.out.printf("Last Index of character: 'l' just before its last occurrence in string : \"%s\", is: %d %n",
                        stringToInspect, stringToInspect.lastIndexOf('l', (stringToInspect.lastIndexOf('l') -1 )));
            }
            System.out.println("****************************************************************************************************************************");
        }
    }

    public static void printStringComparisonResults(String stringToInspect, String stringToInspectToLower){
        System.out.printf("Welcome to this method that demonstrates and prints results of comparison of two Strings: %s, %s %n",
                stringToInspect, stringToInspectToLower);
        if(stringToInspect.equals(stringToInspectToLower)) {
            System.out.println("Values of both strings are exactly" + "equal".toUpperCase());
        }
        if(stringToInspect.contentEquals(stringToInspectToLower)) {
            System.out.println("Content of both strings are exactly" + " equal".toUpperCase());
        }
        if(stringToInspect.equalsIgnoreCase(stringToInspectToLower)) {
            System.out.println("Values of both strings are exactly" + " equal".toUpperCase() + ", after Ignoring the case!");
        }
        if(stringToInspect.startsWith("Hello")) {
            System.out.println("String starts with \'Hello\'");
        }
        if(stringToInspect.endsWith("World")) {
            System.out.println("String ends with \'World\'");
        }
        if(stringToInspect.contains("World")) {
            System.out.println("String contains \'World\'");
        }
        System.out.println("****************************************************************************************************************************");
    }

    public static void demoStringManipulation() {
        System.out.printf("Welcome to this method that demonstrates and prints results of String Manipulation %n");
        String birthDateString = "16/11/1981";
        int yearStartIndex = birthDateString.indexOf("1981");
        System.out.println("Starting index for year 1981 in " + birthDateString + " is: " + yearStartIndex);
        System.out.printf("Birth Year in %s, is: %s %n",birthDateString, birthDateString.substring(yearStartIndex) );
        System.out.printf("Date in  %s, is: %s and Month in %s, is: %s %n",birthDateString, birthDateString.substring(3,5),
                birthDateString,birthDateString.substring(6,birthDateString.length()) );

        String newDate = String.join("/", "16", "11", "1981");
        System.out.println("Demo String.join() : nwwDate formed by using join method with a delimeter '/' is:" + newDate);
        System.out.println("Demo String.replace() : nwwDate formed by replacing the delimeter '/' with '-' is:" + newDate.replace('/', '-'));
        System.out.println("Demo String.replaceFirst() : nwwDate formed by replacing first occurrence of first instance of a  delimeter '/' with '-' is:" +
                newDate.replaceFirst("/", "-"));
        System.out.println("Demo String.replaceAll() : nwwDate formed by replacing all occurrences of the  delimeter '/' with '-'  is:" +
                newDate.replaceFirst("/", "-"));

        System.out.println("************************************************************************************************");

    }

}
