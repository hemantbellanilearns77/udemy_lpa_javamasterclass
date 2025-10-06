package com.hblearns77.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.util;

import com.hblearns77.udemy_lpa_javamasterclass.section12_generics.demostubs.generics_advanced.model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> {

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <S extends QueryItem> List<S> getMatches(List<S> items,
                                                                        String field, String value) {

        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {

        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
