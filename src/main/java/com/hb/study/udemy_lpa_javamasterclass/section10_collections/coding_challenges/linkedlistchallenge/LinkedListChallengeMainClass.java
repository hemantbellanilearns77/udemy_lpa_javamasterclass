package com.hb.study.udemy_lpa_javamasterclass.section10_collections.coding_challenges.linkedlistchallenge;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListChallengeMainClass {

    public static final ExcecutionUtil execution = new ExcecutionUtil();

        public static void main(String[] unusedArgs) {
        //
        execution.initialize();
        LinkedList<Town> itinerary = new LinkedList<>();


        createItineray(itinerary);
        ConsoleStyler.styleInitializationInfo("\nThe list before any user performed operation using the Menu is as below:\n" + itinerary);
        ConsoleStyler.halfDivider();
        var iterator = itinerary.listIterator();
        boolean forward = true;
        Scanner scanner = new Scanner(System.in);
        String nextInput;
        do {
            if (!iterator.hasPrevious()) {
                ConsoleStyler.styleOutput("Originating : " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                ConsoleStyler.styleOutput("Final : " + iterator.previous());
                forward = false;
            }
            printMenu();
            nextInput = scanner.nextLine().trim().toUpperCase();
            switch (nextInput) {
                case "F" -> forward = isABoolean(forward, iterator);
                case "B" -> forward = isForward(forward, iterator);
                case "L" -> listPlaces(itinerary);
                case "M" -> printMenu();
                default ->
                        ConsoleStyler.styleOutput("*".repeat(27) + " Extremely Sorry, but this is an invalid input. try again.... " + "*".repeat(27) + "\n");
            }
        } while (!nextInput.equalsIgnoreCase("Q"));
        execution.finalizeExecution();
    }

    private static boolean isABoolean(boolean forward, ListIterator<Town> iterator) {
        ConsoleStyler.styleOutput("User wants to go forward");
        if (!forward) {           // Reversing Direction
            forward = true;
            if (iterator.hasNext()) {
                iterator.next();  // Adjust position forward
            }
        }
        if (iterator.hasNext()) {
            ConsoleStyler.styleOutput(iterator.next().toString());
        }
        return forward;
    }

    private static boolean isForward(boolean forward, ListIterator<Town> iterator) {
        ConsoleStyler.styleOutput("User wants to go backwards");
        if (forward) {           // Reversing Direction
            forward = false;
            if (iterator.hasPrevious()) {
                iterator.previous();  // Adjust position backwards
            }
        }
        if (iterator.hasPrevious()) {
            ConsoleStyler.styleOutput(iterator.previous().toString());
        }
        return forward;
    }

    private static void listPlaces(LinkedList<Town> itinerary) {
        ConsoleStyler.styleOutput("User wants to list our the itinerary and its as below: ");
        ConsoleStyler.styleOutput(itinerary.toString());
        ConsoleStyler.divider();
    }

    private static void createItineray(LinkedList<Town> itinerary) {
        addTown(new Town("Perth", 3923), itinerary);
        addTown(new Town("Brisbane", 917), itinerary);
        addTown(new Town("Sydney", 0), itinerary);
        addTown(new Town("Alice Springs", 2771), itinerary);
        addTown(new Town("Melbourne", 877), itinerary);
        addTown(new Town("Adelaide", 1374), itinerary);
        addTown(new Town("Darwin", 3972), itinerary);
        addTown(new Town("brisbaNe", 917), itinerary);
    }

    private static void addTown(Town townToAdd, LinkedList<Town> itinerary) {
        ListIterator<Town> itineraryIterator = itinerary.listIterator();
        Town currentTownAtCursor;
        if (itinerary.contains(townToAdd) || checkIfTownExists(townToAdd, itinerary)) {
            ConsoleStyler.styleOutput("*Please Note: Duplicate entry attempt found for '" + townToAdd.town() + "', so not adding it!");
        } else {

            if (!itinerary.isEmpty()) {
                while (itineraryIterator.hasNext()) {
                    currentTownAtCursor = itineraryIterator.next();
                    if (townToAdd.distanceFromOrigin() < currentTownAtCursor.distanceFromOrigin()) {
                        itineraryIterator.previous();
                        itineraryIterator.add(townToAdd);
                        return;
                    }
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
        Town nextTown;
        if (!itinerary.isEmpty()) {
            while (itineraryIterator.hasNext()) {
                nextTown = itineraryIterator.next();
                if (nextTown.town().equalsIgnoreCase(townToAdd.town())) {
                    duplicateFound = true;
                }
            }
        }
        return duplicateFound;
    }

    private static void printMenu() {
        String menuTextBlock = "*".repeat(27) + " Available actions (select letter) " + "*".repeat(27) + """
                (F)orward - to iterate forwards
                (B)ackward - to iterate backwards
                (L)ist Places - to print the itinerary
                (M)enu - to reprint the Menu items
                (Q)uit - to Quit
                Enter Value Below:
                """;
        ConsoleStyler.styleOutput(menuTextBlock);
    }
}
