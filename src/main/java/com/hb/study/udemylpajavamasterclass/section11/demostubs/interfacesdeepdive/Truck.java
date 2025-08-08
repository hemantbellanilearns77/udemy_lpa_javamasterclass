package com.hb.study.udemylpajavamasterclass.section11.demostubs.interfacesdeepdive;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Truck implements Trackable {

    @Override
    public void track() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
