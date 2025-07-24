package com.hb.study.udemylpajavamasterclass.section11.exercises.exercise47;

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
        if(this.root == null) { // root is null, add first Item in list.
            root = newItem;
            itemAdded = true;
            return itemAdded;
        } else {
            int currentComparisonResult = 0;
            ListItem currentItem = this.root;
            while(currentItem != null) {
                currentComparisonResult = currentItem.compareTo(newItem);
                if(currentComparisonResult == 0) {
                    return itemAdded;
                } else {
                    if(currentComparisonResult > 0) {
                        newItem.rightLink = currentItem;
                        if(currentItem.leftLink == null) { // its root....
                            this.root = newItem;
                            currentItem.setPrevious(newItem);
                            itemAdded = true;
                        } else {
                            newItem.setPrevious(currentItem.previous());
                            currentItem.setPrevious(newItem);
                            newItem.setNext(currentItem);
                            itemAdded = true;
                        }
                    } else { // new newItem is either greater
                        currentItem = currentItem.next();
                    }
                }
            }
        }
        return itemAdded;
    }

    @Override
    public boolean removeItem(ListItem itemToRemove) {
        boolean itemRemoved = false;
        ListItem currentItem = getRoot();

        while(currentItem != null) {
            int currentComparisonResult = currentItem.compareTo(itemToRemove);
            if (currentComparisonResult == 0) {
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

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("The list is empty");
        } else {
            ListItem nextItem = root;
            while(nextItem != null){
                System.out.println(nextItem.getValue());
                nextItem = nextItem.next();
            }
        }
    }
}
