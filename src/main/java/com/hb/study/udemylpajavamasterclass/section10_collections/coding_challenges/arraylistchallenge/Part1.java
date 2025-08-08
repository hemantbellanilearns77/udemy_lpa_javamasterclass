package com.hb.study.udemylpajavamasterclass.section10_collections.coding_challenges.arraylistchallenge;

import com.hb.study.udemylpajavamasterclass.global.constants.CommonConstants;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.*;

@SuppressWarnings("ALL")
public class Part1 {

    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> groceries = new ArrayList<>();
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
                ConsoleStyler.divider();
                userInput = 5;
                printMenuOfActions();
                continue;
            }
            if(groceries.isEmpty()) {
                ConsoleStyler.styleOutput("Grocery list is empty right now... ");
            } else if(userInput != 0 ){
                groceries.sort(Comparator.naturalOrder());
                ConsoleStyler.divider();
                ConsoleStyler.styleOutput("Your interim grocery list, sorted(in natural order) is:\n " + groceries);
                ConsoleStyler.divider();
            }
        } while(!(userInput == 0));
        if(groceries.isEmpty()) {
            ConsoleStyler.styleOutput("You ended up with an empty grocery list");
        } else {
            groceries.sort(Comparator.naturalOrder());
            ConsoleStyler.divider();
            ConsoleStyler.styleOutput("Your final grocery list, sorted(in natural order) is:\n " + groceries);
            ConsoleStyler.divider();
        }

    }

    private static void printGroceryState(ArrayList<String> groceries) {
        if(groceries.isEmpty()) {
            ConsoleStyler.styleOutput("Grocery list is empty right now... ");
        } else {
            groceries.sort(Comparator.naturalOrder());
            ConsoleStyler.divider();
            ConsoleStyler.styleOutput("Your interim grocery list, sorted(in natural order) is:\n " + groceries);
            ConsoleStyler.divider();
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
