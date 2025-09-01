package com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.LinkedList;

public class PrimitiveTypesAndCollections {
    public static void main(String[] args) {

        ConsoleStyler.styleExecutionInsight("""
                  Below statement won't compil.
                  Its to demonstrate that primitive types aren't supported by linkedlists and
                   arraylists and generics amd so use wrapper classes as used in compiled program:
                   LinkedList<int> integerLinkedList = new LinkedList<int>();
                """);
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(20);
        ConsoleStyler.styleOutput(integerLinkedList.toString());
        ConsoleStyler.styleExecutionInsight("""
                  Deprecated way of boxing.
                  Integer boxedInt = new Integer(16);
                """);

        Integer boxedInt = Integer.valueOf(15); // correct way
        ConsoleStyler.styleOutput(""+ boxedInt.intValue());
        Integer anotherBoxedInt = 16;//autoboxing
        ConsoleStyler.styleOutput(""+ anotherBoxedInt);
    }
}
