package com.hb.study.javamasterclasscourse.section11.exercises.exercise47;

public interface NodeList {
    ListItem getRoot();
    //, addItem(), removeItem() and traverse() which are package-private and abstract
    boolean addItem(ListItem listItem);

    boolean removeItem(ListItem listItem);

    void traverse(ListItem root);
}
