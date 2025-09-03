package com.hb.study.udemy_lpa_javamasterclass.section11.exercises.exercise47;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;


public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        boolean itemAdded = false;
        if (this.root == null) { // root is null, add first Item in list.
            root = newItem;
            itemAdded = true;
            return itemAdded;
        }

        int currentComparisonResult;
        ListItem currentItem = this.root;
        while (currentItem != null) {
            currentComparisonResult = currentItem.compareTo(newItem);
            if (currentComparisonResult == 0) {
                return itemAdded;
            } else {
                if (currentComparisonResult > 0) {
                    itemAdded = complexItemAddition(newItem, currentItem);
                    break;
                } else { // new newItem is either greater
                    currentItem = currentItem.next();
                }
            }
        }
        return itemAdded;
    }

    private boolean complexItemAddition(ListItem newItem, ListItem currentItem) {
        boolean itemAdded;
        newItem.rightLink = currentItem;
        if (currentItem.leftLink == null) {
            itemAdded = rootItemAdded(newItem, currentItem);
        } else {
            itemAdded = nonRootItemAdded(newItem, currentItem);
        }
        return itemAdded;
    }

    private boolean rootItemAdded(ListItem newItem, ListItem currentItem) {
        boolean itemAdded;
        // its root....
        this.root = newItem;
        currentItem.setPrevious(newItem);
        itemAdded = true;
        return itemAdded;
    }

    private static boolean nonRootItemAdded(ListItem newItem, ListItem currentItem) {
        boolean itemAdded;
        newItem.setPrevious(currentItem.previous());
        currentItem.setPrevious(newItem);
        newItem.setNext(currentItem);
        itemAdded = true;
        return itemAdded;
    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        boolean itemRemoved = false;
        ListItem currentItem = getRoot();

        while (currentItem != null) {
            int currentComparisonResult = currentItem.compareTo(itemToRemove);
            if (currentComparisonResult == 0) {
                itemRemoved = isItemRemoved(currentItem); //method extracted to improve maintainability
                break;
            } else if (currentComparisonResult < 0) {
                currentItem = currentItem.next();
            } else { // comparison > 0
                // we are at an item greater than the one to be deleted
                // so the item is not in the list
                return itemRemoved;
            }
        }
        return itemRemoved;
    }

    private boolean isItemRemoved(ListItem currentItem) {
        boolean itemRemoved;
        // found the item to delete
        if (currentItem == this.root) {
            this.root = currentItem.next();
        } else {
            currentItem.previous().setNext(currentItem.next());
            if (currentItem.next() != null) {
                currentItem.next().setPrevious(currentItem.previous());
            }
        }
        itemRemoved = true;
        return itemRemoved;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            ConsoleStyler.styleOutput("The list is empty");
        } else {
            ListItem nextItem = root;
            while (nextItem != null) {
                ConsoleStyler.styleOutput(nextItem.getValue() + CommonConstants.EMPTYSTRING);
                nextItem = nextItem.next();
            }
        }
    }
}
