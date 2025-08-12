package com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CollectionIntroBasics {

    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String PRODUCE = "PRODUCE";

    public static void main(String[] args) {

        execution.initialize();
        introToArrayLists();

        arraysVsArrayListsVsLists();

        execution.finalizeExecution();
    }
    private static void introToArrayLists() {
        ConsoleStyler.startSection("Introduction to ArrayLists");
        GroceryItem [] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk");
        groceryArray[1] = new GroceryItem("apples", PRODUCE,1);
        groceryArray[2] = new GroceryItem("5 Oranges",PRODUCE,5);
        ConsoleStyler.styleOutput("List of items in groceryArray (GrocerItem records) are: \n" + Arrays.toString(groceryArray));
        ConsoleStyler.halfDivider();

        //noinspection rawtypes
        ArrayList objectList = new ArrayList<>();
        //noinspection unchecked
        objectList.add(new GroceryItem("Butter"));
        //noinspection unchecked
        objectList.add("Yogurt");
        ConsoleStyler.styleOutput("Raw Arraylist (objectList) is: " + objectList);
        ConsoleStyler.halfDivider();

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Cheese"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("apples", PRODUCE,1));
        ConsoleStyler.styleOutput("Type Defined Arraylist (groceryList) is: " + groceryList);
        ConsoleStyler.halfDivider();
        ConsoleStyler.endSection("Introduction to ArrayLists");
    }

    private static void arraysVsArrayListsVsLists(){
        ConsoleStyler.startSection("Arrays vs ArrayLists");
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
        ConsoleStyler.halfDivider();
        ConsoleStyler.endSection("Arrays vs ArrayLists");

    }
}
