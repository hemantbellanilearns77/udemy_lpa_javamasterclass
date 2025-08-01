package com.hb.study.udemylpajavamasterclass.section10_collections.coding_challenges.linkedlistchallenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestItinerary {
    public static String asteriskSeparatorLine = "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " +
            TestItinerary.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";


    public static void main(String[] args) {

        LinkedList<Town> itinerary = new LinkedList<>();
        System.out.println(programOutputBegins);

        createItineray(itinerary);
        System.out.println("\nThe list before any user performed operation using the Menu is as below:");

        System.out.println(itinerary);
        System.out.println(asteriskSeparatorLine);
        var iterator = itinerary.listIterator();
        boolean forward = true;
        //executeMenuCommands();
        Scanner scanner = new Scanner(System.in);
        String nextInput;
        do{
            if (!iterator.hasPrevious()) {
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                System.out.println("Final : " + iterator.previous());
                forward = false;
            }
            printMenu();
            nextInput = scanner.nextLine().trim().toUpperCase();
            switch(nextInput){
                case "F" ->  {
                    System.out.println("User wants to go forward");
                    if (!forward) {           // Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();  // Adjust position forward
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                }
                case "B" ->  {
                    System.out.println("User wants to go backwards");
                    if (forward) {           // Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();  // Adjust position backwards
                        }
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;
                }
                case "L" -> {listPlaces(itinerary); break;}
                case "M" -> {continue;}
                case "Q" -> {break;}
                default -> {
                    System.out.println("*".repeat(27) + " Extremely Sorry, but this is an invalid input. try again.... " + "*".repeat(27) + "\n");
                    break;
                }
            }
        } while (!nextInput.equalsIgnoreCase("Q"));


    }

    private static void listPlaces(LinkedList<Town> itinerary) {
        System.out.println("User wants to list our the itinerary and its as below: \n ");
        System.out.println(itinerary);
        System.out.println(asteriskSeparatorLine);
    }



    private static void iterateForwards(LinkedList<Town> itinerary) {
        System.out.println("User wants to go forward.... ");

    }

   /* private static void executeMenuCommands(LinkedList<Town> itinerary) {
        Scanner scanner = new Scanner(System.in);
        String nextInput;
        do{

            nextInput = scanner.nextLine();
            switch(nextInput){
                case "F" ->  {iterateForwards(itinerary); printMenu();}
                case "B" ->  {iterateBackwards(itinerary); printMenu();}
                case "L" -> {listPlaces(itinerary); printMenu();}
                case "M" -> {printMenu();}
                case "Q" -> {break;}
                default -> {
                    System.out.println("Sorry, invalid input ");
                    break;}
            }
        } while (!nextInput.equalsIgnoreCase("Q"));

    }*/

    private static void createItineray(LinkedList<Town> itinerary) {

        addTown(new Town("Perth", 3923),itinerary);
        addTown(new Town("Brisbane", 917),itinerary);
        addTown(new Town("Sydney",0), itinerary);
        addTown(new Town("Alice Springs", 2771),itinerary);
        addTown(new Town("Melbourne", 877),itinerary);
        addTown(new Town("Adelaide", 1374),itinerary);
        addTown(new Town("Darwin", 3972),itinerary);
       addTown(new Town("brisbaNe", 917),itinerary);


    }


    private static void addTown(Town townToAdd, LinkedList<Town> itinerary) {
        ListIterator<Town> itineraryIterator = itinerary.listIterator();
        Town currentTownAtCursor;
        if(itinerary.contains(townToAdd) || checkIfTownExists(townToAdd, itinerary)) {
            System.out.println("*Please Note: Duplicate entry attempt found for \'" + townToAdd.town() + "\', so not adding it!");
            return;
        } else {

            if(itinerary.size() != 0){
                while(itineraryIterator.hasNext()) {
                    currentTownAtCursor = itineraryIterator.next();
                    //if(itineraryIterator.hasNext()) {
                        if(townToAdd.distanceFromOrigin() < currentTownAtCursor.distanceFromOrigin()){
                            itineraryIterator.previous();
                            itineraryIterator.add(townToAdd);
                            return;
                        }
                    //}
                }
                itineraryIterator.add(townToAdd);
            } else {
                itineraryIterator.add(townToAdd);
            }
        }
    }

    private static boolean checkIfTownExists(Town townToAdd, LinkedList<Town> itinerary) {
        boolean duplicateFound = false;
        ListIterator<Town> itineraryIterator = itinerary.listIterator();
        Town nextTown = null;
        if(itinerary.size() > 0) {
            while(itineraryIterator.hasNext()) {
                nextTown = itineraryIterator.next();
                if(nextTown.town().equalsIgnoreCase(townToAdd.town())) {
                    duplicateFound = true;
                }
            }
        }
        return duplicateFound;
    }

    private static void removeTown(Town townToRemove, LinkedList<Town> itinerary){
        //itinerary.remove(town)
    }

    private static void printMenu(){
        String menuTextBlock = "*".repeat(27) + " Available actions (select letter) " + "*".repeat(27) + "\n" +
                """ 
                (F)orward - to iterate forwards
                (B)ackward - to iterate backwards
                (L)ist Places - to print the itinerary
                (M)enu - to reprint the Menu items
                (Q)uit - to Quit 
                Enter Value: """;
        System.out.print(menuTextBlock);
    }
}
