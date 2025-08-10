package com.hb.study.udemy_lpa_javamasterclass.section11.exercises.exercise47;

public abstract class ListItem {
    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    abstract ListItem next();
    abstract ListItem setNext(ListItem listItem);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem listItem);

    abstract int compareTo(ListItem item);

    public ListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}