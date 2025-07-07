package com.hb.study.javamasterclasscourse.section8_oop_part2.exercises.exercise39;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel < 0 || tonerLevel>100) {
            tonerLevel=-1;
        } else {
            this.tonerLevel = tonerLevel;
        }
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){
        if(tonerAmount > 0 && tonerAmount <= 100) {
            if( (tonerLevel + tonerAmount) > 100 ){
                return -1;
            } else {
                tonerLevel += tonerAmount;
                return tonerLevel;
            }
        }
        return -1;
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if(getDuplex()) {
            pagesToPrint = (pages / 2 ) + (pages % 2);
        }
        pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }


    public int getPagesPrinted() {
        return pagesPrinted;
    }
    public boolean getDuplex() {
        return duplex;
    }
}
