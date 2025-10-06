package com.hblearns77.udemy_lpa_javamasterclass.section11.exercises.exercise47;

public abstract class ListItem {
    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    abstract ListItem next();
    abstract void setNext(ListItem listItem);
    abstract ListItem previous();
    abstract void setPrevious(ListItem listItem);

    abstract int compareTo(ListItem item);

    protected ListItem(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}