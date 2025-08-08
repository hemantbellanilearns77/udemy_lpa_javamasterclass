package com.hb.study.udemylpajavamasterclass.section10_collections.demostubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.LinkedList;

public class PrimitiveTypesAndCollections {
    public static void main(String[] args) {
/*
        Below statement won't compile, its to demonstrate that primitive types aren't supported by
        linkedlists and arraylists and generics amd so use wrapper classes as show below
*/
        //LinkedList<int> linkedList = new LinkedList<int>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        ConsoleStyler.styleOutput(linkedList.toString());
        //Deprecated way of boxing
        // Integer boxedInt = new Integer(16);

        Integer boxedInt = Integer.valueOf(15); // correct way
        ConsoleStyler.styleOutput(""+ boxedInt.intValue());
        Integer anotherBoxedInt = 16;//autoboxing
    }
}
