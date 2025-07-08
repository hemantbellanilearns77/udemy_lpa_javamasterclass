package com.hb.study.udemylpajavamasterclass.section11.misc_practice.interfacesdeepdive;

public class Truck implements Trackable {

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
