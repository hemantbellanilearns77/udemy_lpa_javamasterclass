package com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.util.LinkedList;

public class LinkedListVsArrayList {
    public static String asteriskSeparatorLine = "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " +
            LinkedListVsArrayList.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";

    public static void main(String[] args) {
        ConsoleStyler.styleOutput(programOutputBegins);
        LinkedList<String> placesToVisit = new LinkedList<>();
        //var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        ConsoleStyler.styleOutput("Places to visit before any call to addMoreElements Method are: " + placesToVisit);
        //addMoreElements(placesToVisit);
        //ConsoleStyler.styleOutput("Places to visit after a call to LinkedLIst Add-Data Methods ( addFirst and addLast : addMoreElements ) are: " + placesToVisit);
        //addMoreElements(placesToVisit);
        //ConsoleStyler.styleOutput("Places to visit after a call to Queue Add-Data  Methods ( offer, offerFirst and offerLast: addMoreElements ) are: " + placesToVisit);
        addMoreElements(placesToVisit);
        ConsoleStyler.styleOutput("Places to visit after a call to Stack Add-Data  Methods ( push : addMoreElements ) are: " + placesToVisit);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
        //ConsoleStyler.styleOutput("Places to visit before any call to removeElements Method are: " + placesToVisit);
    /*    removeElements(placesToVisit);
        ConsoleStyler.styleOutput("Places to visit after a call to LinkedList Remove-Data Methods ( remove and remove(index-4) : removeElements ) are: \n "
               + placesToVisit);
*/
/*        removeElements(placesToVisit);
        ConsoleStyler.styleOutput("Places to visit after a call to Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: \n "
                + placesToVisit);*/
/*        removeElements(placesToVisit);
        ConsoleStyler.styleOutput("Places to visit after a call to Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: \n "
                + placesToVisit);*/
/*        removeElements(placesToVisit);
        ConsoleStyler.styleOutput("Places to visit after a call to Stack Remove-Data Methods ( pop : removeElements ) are: \n "
                + placesToVisit);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);*/

        ConsoleStyler.styleOutput("Places to visit before demonstrating the gettingElement methods are:\n" +placesToVisit);
        gettingElements(placesToVisit);
        ConsoleStyler.styleOutput(asteriskSeparatorLine);
    }

    private static void addMoreElements(LinkedList<String> placesToVisit) {
        placesToVisit.addFirst("Darwin");
        placesToVisit.addLast("Hobart");

        //Queue Methods
        placesToVisit.offer("Melbourne");
        placesToVisit.offerFirst("Brisbane");
        placesToVisit.offerLast("Toowoomba");
        // Stack Methods
        placesToVisit.push("Alice Springs");

    }

    private static void removeElements(LinkedList<String> placesToVisit) {
        placesToVisit.remove(4);
        placesToVisit.remove("Brisbane");
/*        ConsoleStyler.styleOutput(placesToVisit);
        ConsoleStyler.styleOutput(placesToVisit.size());*/
        //Queue removal methods
        String s1 = placesToVisit.remove();
        ConsoleStyler.styleOutput(s1 + " was removed from placesToVisit.");
        String s2 = placesToVisit.removeFirst();
        ConsoleStyler.styleOutput(s2 + " was removed from placesToVisit.");
        String s3 = placesToVisit.removeLast();
        ConsoleStyler.styleOutput(s3 + " was removed from placesToVisit.");

        //Additional LinkedList Removal Methods:
        String p1 = placesToVisit.poll(); // remove first
        ConsoleStyler.styleOutput(p1 + " was removed from placesToVisit.");
        String p2 = placesToVisit.pollFirst(); // remove first
        ConsoleStyler.styleOutput(p2 + " was removed from placesToVisit.");
        String p3 = placesToVisit.pollLast();
        ConsoleStyler.styleOutput(p3 + " was removed from placesToVisit.");
        ConsoleStyler.styleOutput("Places to visit after polling methods is: :\n"
                + placesToVisit);
        //Stack push and pop methods
        placesToVisit.push("Sydney");
        placesToVisit.push("Brisbane");
        placesToVisit.push("Canberra");
        ConsoleStyler.styleOutput("Places to visit after pushing new elements are:\n"
                        + placesToVisit);
        String p4 = placesToVisit.pop();
        ConsoleStyler.styleOutput(p4 + " was popped from placesToVisit.");

    }
    private static void gettingElements(LinkedList<String> placesToVisit) {
        ConsoleStyler.styleOutput("Element at index 4: " + placesToVisit.get(4));
        ConsoleStyler.styleOutput("First Element: " + placesToVisit.getFirst());
        ConsoleStyler.styleOutput("Last Element: " + placesToVisit.getLast());
        ConsoleStyler.styleOutput("index of Dawwin: " + placesToVisit.indexOf("Darwin"));
        ConsoleStyler.styleOutput("Last index of Melbourne: " + placesToVisit.lastIndexOf("Melbourne"));
        ConsoleStyler.styleOutput("Get Element in Queue using method element(): " + placesToVisit.element() );
        ConsoleStyler.styleOutput("Peek Element in Queue using method peek(): " + placesToVisit.peek() );
        ConsoleStyler.styleOutput("Peek First Element in Queue using method peekFirst(): " + placesToVisit.peekFirst() );
        ConsoleStyler.styleOutput("Peek Last Element in Queue using method peekLast(): " + placesToVisit.peekLast() );


    }


}
