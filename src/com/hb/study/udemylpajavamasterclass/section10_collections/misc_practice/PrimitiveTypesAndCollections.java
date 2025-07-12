package com.hb.study.udemylpajavamasterclass.section10_collections.misc_practice;

import java.util.LinkedList;

public class PrimitiveTypesAndCollections {
    public static void main(String[] args) {
/*
        Below statement won't compile, its to demonstrate that primitive types aren't supported by
        linkedlists and arraylists and generics amd so use wrapper classes as show below
*/
        //LinkedList<int> linkedList = new LinkedList<int>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
        //Deprecated way of boxing
        // Integer boxedInt = new Integer(16);

        Integer boxedInt = Integer.valueOf(15); // correct way
        System.out.println(boxedInt.intValue());
        Integer anotherBoxedInt = 16;//autoboxing
    }
}
