package com.hblearns77.udemy_lpa_javamasterclass.section11.exercises.exercise47;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    void setNext(ListItem listItem) {
        this.rightLink = listItem;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }
    @Override
    void setPrevious(ListItem listItem) {
        this.leftLink = listItem;
    }

    @Override
    int compareTo(ListItem item) {

        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }

}
