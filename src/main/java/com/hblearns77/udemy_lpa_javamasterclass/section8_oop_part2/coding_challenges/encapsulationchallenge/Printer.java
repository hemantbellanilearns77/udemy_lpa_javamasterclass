package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.coding_challenges.encapsulationchallenge;

import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

public class Printer {
    private int tonerPercentage;
    private final boolean duplex;
    private int pagesPrinted;

    @Override
    public String toString() {
        return "Printer{" +
                "tonerPercentage=" + tonerPercentage +
                ", duplex=" + duplex +
                ", pagesPrinted=" + pagesPrinted +
                '}';
    }

    public Printer(int tonerPercentage, boolean duplex) {
        this.duplex = duplex;
        setPagesPrinted(0);
        setTonerPercentage(tonerPercentage);
        ConsoleStyler.styleInitializationInfo("""
                Printer initialized as: %n%s
                """.formatted(this.toString()));
    }
    private void setPagesPrinted(int pagesPrinted) {
        if(pagesPrinted < 0) {
            this.pagesPrinted = 0;
        } else {
            this.pagesPrinted += pagesPrinted;
        }
    }

    private void setTonerPercentage(int tonerPercentage) {
        this.tonerPercentage = (tonerPercentage>=0 && tonerPercentage <= 100) ? tonerPercentage: -1;
    }
    public int addToner(int tonerAmount) {

        if(this.tonerPercentage + tonerAmount > 100) {
            ConsoleStyler.styleOutput("Cannot add this much to toner, as it will exceed the permissible limit");
            return -1;
        }
        tonerPercentage += tonerAmount;
        return this.tonerPercentage;
    }

    public int printPages(int pagesToPrint){
        int sheetsToBeConsumed = 0;
        if(duplex) {
            ConsoleStyler.styleOutput("Printing in duplex mode");
            sheetsToBeConsumed = (int) Math.ceil((double) pagesToPrint /2);
        }
        if (this.tonerPercentage < (sheetsToBeConsumed / 10)) {
            sheetsToBeConsumed = tonerPercentage * 10;
            ConsoleStyler.styleOutput("The number of sheets that could be printed is: " + sheetsToBeConsumed +
                    " because printer ran out of toner ... ");
            setTonerPercentage(0);
            setPagesPrinted(sheetsToBeConsumed);
        } else {
            setTonerPercentage(this.tonerPercentage - (sheetsToBeConsumed / 10));
            setPagesPrinted(sheetsToBeConsumed);
        }
        return sheetsToBeConsumed;

    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

}

