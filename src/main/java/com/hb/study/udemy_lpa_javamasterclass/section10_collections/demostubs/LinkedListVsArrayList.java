package com.hb.study.udemy_lpa_javamasterclass.section10_collections.demostubs;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExecutionUtil;

import java.util.LinkedList;

public class LinkedListVsArrayList {

    public static final ExecutionUtil execution = new ExecutionUtil();
    private static final String BRISBANE = "Brisbane";
    private static final String WAS_REMOVED_FROM_PLACES_TO_VISIT = "was removed from placesToVisit.";
    private static final String PLACES_TO_VISIT_AFTER_A_CALL_TO = "Places to visit after a call to";

        public static void main(String[] args) {
        //
        execution.initialize(args);
        ConsoleStyler.divider();
        LinkedList<String> placesToVisit = new LinkedList<>();
        placesToVisit.add("Sydney");
        placesToVisit.addFirst("Canberra");
        ConsoleStyler.styleOutput("Places to visit before any call to addMoreElements Method are: " + placesToVisit);
        addMoreElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " LinkedLIst Add-Data Methods ( addFirst and addLast : addMoreElements ) are: " + placesToVisit);
        addMoreElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " Queue Add-Data  Methods ( offer, offerFirst and offerLast: addMoreElements ) are: " + placesToVisit);
        addMoreElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " Stack Add-Data  Methods ( push : addMoreElements ) are: " + placesToVisit);
        ConsoleStyler.divider();
        ConsoleStyler.styleOutput("Places to visit before any call to removeElements Method are: " + placesToVisit);
        removeElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " LinkedList Remove-Data Methods ( remove and remove(index-4) : removeElements ) are: CommonConstants.NEWLINE "
                + placesToVisit);

        if (!placesToVisit.isEmpty()) removeElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: CommonConstants.NEWLINE "
                + placesToVisit);
        removeElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " Queue Remove-Data Methods ( remove, removeFirst and removeLast : removeElements ) are: CommonConstants.NEWLINE "
                + placesToVisit);
        removeElements(placesToVisit);
        ConsoleStyler.styleOutput(PLACES_TO_VISIT_AFTER_A_CALL_TO + " Stack Remove-Data Methods ( pop : removeElements ) are: CommonConstants.NEWLINE "
                + placesToVisit);
        ConsoleStyler.divider();

        ConsoleStyler.styleOutput("Places to visit before demonstrating the gettingElement methods are:CommonConstants.NEWLINE" + placesToVisit);
        gettingElements(placesToVisit);
        ConsoleStyler.divider();
        execution.finalizeExecution();
    }

    private static void addMoreElements(LinkedList<String> placesToVisit) {
        placesToVisit.addFirst("Darwin");
        placesToVisit.addLast("Hobart");

        //Queue Methods
        placesToVisit.offer("Melbourne");
        placesToVisit.offerFirst(BRISBANE);
        placesToVisit.offerLast("Toowoomba");
        // Stack Methods
        placesToVisit.push("Alice Springs");

    }

    private static void removeElements(LinkedList<String> placesToVisit) {
        if (placesToVisit.size() >= 5) {
            placesToVisit.remove(4);
            placesToVisit.remove(BRISBANE);
        }
        ConsoleStyler.styleEachAsIs(null, placesToVisit);
        ConsoleStyler.styleOutput("" + placesToVisit.size());
        //Queue removal methods
        String s1 = placesToVisit.remove();
        ConsoleStyler.styleOutput(s1 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        String s2 = placesToVisit.removeFirst();
        ConsoleStyler.styleOutput(s2 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        if(!placesToVisit.isEmpty()) {
            String s3 = placesToVisit.removeLast();
            ConsoleStyler.styleOutput(s3 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        }

        //Additional LinkedList Removal Methods:
        String p1 = placesToVisit.poll(); // remove first
        ConsoleStyler.styleOutput(p1 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        String p2 = placesToVisit.pollFirst(); // remove first
        ConsoleStyler.styleOutput(p2 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        String p3 = placesToVisit.pollLast();
        ConsoleStyler.styleOutput(p3 + " " + WAS_REMOVED_FROM_PLACES_TO_VISIT);
        ConsoleStyler.styleOutput("Places to visit after polling methods is: :CommonConstants.NEWLINE"
                + placesToVisit);
        //Stack push and pop methods
        placesToVisit.push("Sydney");
        placesToVisit.push(BRISBANE);
        placesToVisit.push("Canberra");
        ConsoleStyler.styleOutput("Places to visit after pushing new elements are:CommonConstants.NEWLINE"
                + placesToVisit);
        String p4 = placesToVisit.pop();
        ConsoleStyler.styleOutput(p4 + " was popped from placesToVisit.");

    }

    private static void gettingElements(LinkedList<String> placesToVisit) {
        if(placesToVisit.size() > 4)  {
            ConsoleStyler.styleOutput("Element at index 4: " + placesToVisit.get(4));
        }
        ConsoleStyler.styleOutput("First Element: " + placesToVisit.getFirst());
        ConsoleStyler.styleOutput("Last Element: " + placesToVisit.getLast());
        ConsoleStyler.styleOutput("index of Dawwin: " + placesToVisit.indexOf("Darwin"));
        ConsoleStyler.styleOutput("Last index of Melbourne: " + placesToVisit.lastIndexOf("Melbourne"));
        ConsoleStyler.styleOutput("Get Element in Queue using method element(): " + placesToVisit.element());
        ConsoleStyler.styleOutput("Peek Element in Queue using method peek(): " + placesToVisit.peek());
        ConsoleStyler.styleOutput("Peek First Element in Queue using method peekFirst(): " + placesToVisit.peekFirst());
        ConsoleStyler.styleOutput("Peek Last Element in Queue using method peekLast(): " + placesToVisit.peekLast());


    }


}
