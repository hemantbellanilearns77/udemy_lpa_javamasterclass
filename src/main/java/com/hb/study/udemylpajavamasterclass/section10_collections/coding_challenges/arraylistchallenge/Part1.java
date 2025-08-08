package com.hb.study.udemylpajavamasterclass.section10_collections.coding_challenges.arraylistchallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.*;

@SuppressWarnings("ALL")
public class Part1 {
   /* private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while (flag) {
            printActions();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            ConsoleStyler.styleOutput(groceries);
        }
    }

    private static void addItems(ArrayList<String> groceries) {

        ConsoleStyler.styleOutput("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
//        groceries.addAll(List.of(items));

        for (String i: items) {
            String trimmed = i.trim();
            if (groceries.indexOf(trimmed) < 0) {
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {

        ConsoleStyler.styleOutput("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");

        for (String i: items) {
            String trimmed = i.trim();
            groceries.remove(trimmed);
        }
    }
    private static void printActions() {

        String textBlock = """
                Available actions:
                                
                0 - to shut down
                                
                1 - to add item(s) to list (comma delimited list)
                                
                2 - to remove any items (comma delimited list)
                                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }*/

    public static String asteriskSeparatorLine =  "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " + Part1.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> groceries = new ArrayList<>();
        ConsoleStyler.styleOutput(programOutputBegins);
        do {
            printMenuOfActions();
            try {
                userInput = scanner.nextInt();
                switch(userInput) {
                    case 1 -> { addGroceryItems(groceries); }
                    case 2 -> { removeGroceryItems(groceries);
                        ConsoleStyler.styleOutput(userInput  + CommonConstants.EMPTYSTRING); }
                    case 3 ->  {
                        printGroceryState(groceries);
                    }
                    default -> {
                        ConsoleStyler.styleOutput("Sorry, yoy input a number our of acceptable range of inputs (1 or 2 or 3)... " +
                                "Please try again by entering the acceptable integer.... ");
                        break; }
                }
            } catch (InputMismatchException inputMismatchException) {
                ConsoleStyler.styleOutput("Invalid Input, try again... here's the menu again");
                ConsoleStyler.styleOutput(asteriskSeparatorLine);
                userInput = 5;
                printMenuOfActions();
                continue;
            }
            if(groceries.isEmpty()) {
                ConsoleStyler.styleOutput("Grocery list is empty right now... ");
            } else if(userInput != 0 ){
                groceries.sort(Comparator.naturalOrder());
                ConsoleStyler.styleOutput(asteriskSeparatorLine);
                ConsoleStyler.styleOutput("Your interim grocery list, sorted(in natural order) is:\n " + groceries);
                ConsoleStyler.styleOutput(asteriskSeparatorLine);
            }
        } while(!(userInput == 0));
        if(groceries.isEmpty()) {
            ConsoleStyler.styleOutput("You ended up with an empty grocery list");
        } else {
            groceries.sort(Comparator.naturalOrder());
            ConsoleStyler.styleOutput(asteriskSeparatorLine);
            ConsoleStyler.styleOutput("Your final grocery list, sorted(in natural order) is:\n " + groceries);
            ConsoleStyler.styleOutput(asteriskSeparatorLine);
        }

    }

    private static void printGroceryState(ArrayList<String> groceries) {
        if(groceries.isEmpty()) {
            ConsoleStyler.styleOutput("Grocery list is empty right now... ");
        } else {
            groceries.sort(Comparator.naturalOrder());
            ConsoleStyler.styleOutput(asteriskSeparatorLine);
            ConsoleStyler.styleOutput("Your interim grocery list, sorted(in natural order) is:\n " + groceries);
            ConsoleStyler.styleOutput(asteriskSeparatorLine);
        }
    }

    private static void addGroceryItems(ArrayList<String> groceryList ) {
        Scanner scanner = new Scanner(System.in);

        ConsoleStyler.styleOutput("Add a comma separated list of grocery items: ");
        String userInput = scanner.nextLine();
        String[] inputItems = userInput.split(",");
        //ConsoleStyler.styleOutput(Arrays.toString(inputItems));
        for(String inputItem : inputItems) {
            if(!groceryList.contains(inputItem.trim())) {
                groceryList.add(inputItem.trim());
            }
        }
        //ConsoleStyler.styleOutput(groceryList);
        //ConsoleStyler.styleOutput(asteriskSeparatorLine);
    }

    private static void removeGroceryItems(ArrayList<String> groceryList ) {
        Scanner scanner = new Scanner(System.in);

        ConsoleStyler.styleOutput("Remove a comma separated list of grocery items: ");
        String userInput = scanner.nextLine();
        String [] inputItems = userInput.split(",");
        for(String inputItem : inputItems) {
            groceryList.remove(inputItem.trim());
        }

    }
    private static void printMenuOfActions(){
        String textBlock = """
                Available actions:

                0 - to shutdown

                1 - to add item(s) to list (comma delimited list)

                2 - to remove any items (comma delimited list)

                3 - to print grocery state (interim)

                Enter a number for which action you want to do:
                """;
        System.out.print(textBlock + " ");
    }
}
