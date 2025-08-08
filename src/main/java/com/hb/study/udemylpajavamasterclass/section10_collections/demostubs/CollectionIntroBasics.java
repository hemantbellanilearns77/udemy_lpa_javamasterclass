package com.hb.study.udemylpajavamasterclass.section10_collections.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class CollectionIntroBasics {
    public static String asteriskSeparatorLine =  "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " + CollectionIntroBasics.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";

    public static void main(String[] args) {
        ConsoleStyler.styleOutput(programOutputBegins);
        introToArrayLists();

        arraysVsArrayListsVsLists();


    }
    private static void introToArrayLists() {
        GroceryItem [] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE",1);
        groceryArray[2] = new GroceryItem("5 Oranges","PRODUCE",5);
        ConsoleStyler.styleOutput("List of items in groceryArray (GrocerItem records) are: \n" + Arrays.toString(groceryArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

        //noinspection rawtypes
        ArrayList objectList = new ArrayList<>();
        //noinspection unchecked
        objectList.add(new GroceryItem("Butter"));
        //noinspection unchecked
        objectList.add("Yogurt");
        ConsoleStyler.styleOutput("Raw Arraylist (objectList) is: " + objectList);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Cheese"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("apples", "PRODUCE",1));
        ConsoleStyler.styleOutput("Type Defined Arraylist (groceryList) is: " + groceryList);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
    }

    private static void arraysVsArrayListsVsLists(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        //noinspection ConstantConditions
        ConsoleStyler.styleOutput("Default size of any ArrayList is: " + stringArrayList.size());
        stringArrayList.add("Dummy Entry");

        String[] newStringArray = {"First","Second","Third"};
        var newStrArrayList = Arrays.asList(newStringArray);
        ConsoleStyler.styleOutput("The type adopted by var for newStrArrayList is: "
                + newStrArrayList.getClass().getTypeName());
        ConsoleStyler.styleOutput("The newStrArrayList is: " + newStrArrayList);
        //setting the change on arraylist will impact the source array as well...
        newStrArrayList.set(0,"1st");
        ConsoleStyler.styleOutput("Array now: " + Arrays.toString(newStringArray));
        ConsoleStyler.styleOutput("List (ArrayList) now: " + newStrArrayList);
        //sorting an Arraylist using natural order:
        newStrArrayList.sort(Comparator.naturalOrder());
        ConsoleStyler.styleOutput("\nThe sorted (in natural order) version: " + Arrays.toString(newStringArray));
        newStrArrayList.sort(Comparator.reverseOrder());
        ConsoleStyler.styleOutput("\nThe sorted (reverseOrder) version: " + Arrays.toString(newStringArray));
        ConsoleStyler.styleOutput(asteriskSeparatorLine);

    }
}
