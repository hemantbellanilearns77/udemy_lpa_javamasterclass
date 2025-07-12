package com.hb.study.udemylpajavamasterclass.section10_collections.misc_practice;

import java.util.LinkedList;

public class LinkedListVsArrayList {
    public static String asteriskSeparatorLine = "*".repeat(153) + "\n";
    public static String programOutputBegins = "\n" + "*".repeat(54) + " The Output of " +
            LinkedListVsArrayList.class.getSimpleName() + " is as below " + "*".repeat(54) + "\n";

    public static void main(String[] args) {
        System.out.println(programOutputBegins);
        LinkedList<String> placesToVisit = new LinkedList<>();
        //var placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println("Places to visit before any call to addMoreElements Method are: " + placesToVisit);
        //addMoreElements(placesToVisit);
        //System.out.println("Places to visit after a call to LinkedLIst Add-Data Methods ( addFirst and addLast : addMoreElements ) are: " + placesToVisit);
        //addMoreElements(placesToVisit);
        //System.out.println("Places to visit after a call to Queue Add-Data  Methods ( offer, offerFirst and offerLast: addMoreElements ) are: " + placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println("Places to visit after a call to Stack Add-Data  Methods ( push : addMoreElements ) are: " + placesToVisit);
        System.out.println(asteriskSeparatorLine);
        //System.out.println("Places to visit before any call to removeElements Method are: " + placesToVisit);
    /*    removeElements(placesToVisit);
        System.out.println("Places to visit after a call to LinkedList Remove-Data Methods ( remove and remove(index-4) : removeElements ) are: \n "
               + placesToVisit);
*/
/*        removeElements(placesToVisit);
        System.out.println("Places to visit after a call to Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: \n "
                + placesToVisit);*/
/*        removeElements(placesToVisit);
        System.out.println("Places to visit after a call to Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: \n "
                + placesToVisit);*/
/*        removeElements(placesToVisit);
        System.out.println("Places to visit after a call to Stack Remove-Data Methods ( pop : removeElements ) are: \n "
                + placesToVisit);
        System.out.println(asteriskSeparatorLine);*/

        System.out.println("Places to visit before demonstrating the gettingElement methods are:\n" +placesToVisit);
        gettingElements(placesToVisit);
        System.out.println(asteriskSeparatorLine);
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
/*        System.out.println(placesToVisit);
        System.out.println(placesToVisit.size());*/
        //Queue removal methods
        String s1 = placesToVisit.remove();
        System.out.println(s1 + " was removed from placesToVisit.");
        String s2 = placesToVisit.removeFirst();
        System.out.println(s2 + " was removed from placesToVisit.");
        String s3 = placesToVisit.removeLast();
        System.out.println(s3 + " was removed from placesToVisit.");

        //Additional LinkedList Removal Methods:
        String p1 = placesToVisit.poll(); // remove first
        System.out.println(p1 + " was removed from placesToVisit.");
        String p2 = placesToVisit.pollFirst(); // remove first
        System.out.println(p2 + " was removed from placesToVisit.");
        String p3 = placesToVisit.pollLast();
        System.out.println(p3 + " was removed from placesToVisit.");
        System.out.println("Places to visit after polling methods is: :\n"
                + placesToVisit);
        //Stack push and pop methods
        placesToVisit.push("Sydney");
        placesToVisit.push("Brisbane");
        placesToVisit.push("Canberra");
        System.out.println("Places to visit after pushing new elements are:\n"
                        + placesToVisit);
        String p4 = placesToVisit.pop();
        System.out.println(p4 + " was popped from placesToVisit.");

    }
    private static void gettingElements(LinkedList<String> placesToVisit) {
        System.out.println("Element at index 4: " + placesToVisit.get(4));
        System.out.println("First Element: " + placesToVisit.getFirst());
        System.out.println("Last Element: " + placesToVisit.getLast());
        System.out.println("index of Dawwin: " + placesToVisit.indexOf("Darwin"));
        System.out.println("Last index of Melbourne: " + placesToVisit.lastIndexOf("Melbourne"));
        System.out.println("Get Element in Queue using method element(): " + placesToVisit.element() );
        System.out.println("Peek Element in Queue using method peek(): " + placesToVisit.peek() );
        System.out.println("Peek First Element in Queue using method peekFirst(): " + placesToVisit.peekFirst() );
        System.out.println("Peek Last Element in Queue using method peekLast(): " + placesToVisit.peekLast() );


    }


}
