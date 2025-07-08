package com.hb.study.udemylpajavamasterclass.section10_collections.misc_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;



public class CollectionIntroBasics {
    public static String asteriskSeparatorLine =  "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " + CollectionIntroBasics.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";

    public static void main(String[] args) {
        System.out.println(programOutputBegins);
        introToArrayLists();

        arraysVsArrayListsVsLists();


    }
    private static void introToArrayLists() {
        GroceryItem [] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE",1);
        groceryArray[2] = new GroceryItem("5 Oranges","PRODUCE",5);
        System.out.println("List of items in groceryArray (GrocerItem records) are: \n" + Arrays.toString(groceryArray));
        System.out.println(asteriskSeparatorLine);

        //noinspection rawtypes
        ArrayList objectList = new ArrayList<>();
        //noinspection unchecked
        objectList.add(new GroceryItem("Butter"));
        //noinspection unchecked
        objectList.add("Yogurt");
        System.out.println("Raw Arraylist (objectList) is: " + objectList);
        System.out.println(asteriskSeparatorLine);

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Cheese"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("apples", "PRODUCE",1));
        System.out.println("Type Defined Arraylist (groceryList) is: " + groceryList);
        System.out.println(asteriskSeparatorLine);
    }

    private static void arraysVsArrayListsVsLists(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        //noinspection ConstantConditions
        System.out.println("Default size of any ArrayList is: " + stringArrayList.size());
        stringArrayList.add("Dummy Entry");
        System.out.println();

        String[] newStringArray = {"First","Second","Third"};
        var newStrArrayList = Arrays.asList(newStringArray);
        System.out.println("The type adopted by var for newStrArrayList is: "
                + newStrArrayList.getClass().getTypeName());
        System.out.println("The newStrArrayList is: " + newStrArrayList);
        //setting the change on arraylist will impact the source array as well...
        newStrArrayList.set(0,"1st");
        System.out.println("Array now: " + Arrays.toString(newStringArray));
        System.out.println("List (ArrayList) now: " + newStrArrayList);
        //sorting an Arraylist using natural order:
        newStrArrayList.sort(Comparator.naturalOrder());
        System.out.println("\nThe sorted (in natural order) version: " + Arrays.toString(newStringArray));
        newStrArrayList.sort(Comparator.reverseOrder());
        System.out.println("\nThe sorted (reverseOrder) version: " + Arrays.toString(newStringArray));
        System.out.println(asteriskSeparatorLine);

    }
}
