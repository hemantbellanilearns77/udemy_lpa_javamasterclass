package com.hblearns77.udemy_lpa_javamasterclass.section11.demostubs.interfacesdeepdive;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Truck implements Trackable {

    @Override
    public void track() {
        ConsoleStyler.styleOutput(getClass().getSimpleName() + "'s coordinates recorded");
    }
}
