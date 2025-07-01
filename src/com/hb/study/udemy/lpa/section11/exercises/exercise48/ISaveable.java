package com.hb.study.udemy.lpa.section11.exercises.exercise48;

import java.util.List;

public interface ISaveable {
    List<String>  write();
    void read(List<String> stringList);
}
