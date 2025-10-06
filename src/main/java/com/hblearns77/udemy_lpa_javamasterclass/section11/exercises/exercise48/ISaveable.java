package com.hblearns77.udemy_lpa_javamasterclass.section11.exercises.exercise48;

import java.util.List;

public interface ISaveable {
    List<String>  write();
    void read(List<String> stringList);
}
