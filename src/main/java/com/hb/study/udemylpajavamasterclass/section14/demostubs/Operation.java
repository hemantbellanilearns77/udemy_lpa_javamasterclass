package com.hb.study.udemylpajavamasterclass.section14.demostubs;

/**
created by : heman on 17-07-2025, 11:56 am, in the "udemy_lpa_javamasterclass" project
**/

@FunctionalInterface
public interface Operation<T> {

    T operate (T value1, T value2);

}
