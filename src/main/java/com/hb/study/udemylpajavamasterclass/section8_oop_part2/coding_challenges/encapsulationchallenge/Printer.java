package com.hb.study.udemylpajavamasterclass.section8_oop_part2.coding_challenges.encapsulationchallenge;

public class Printer {
    private int tonerPercentage;
    private boolean duplex;
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
        this.toString();
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
            System.out.println("Cannot add this much to toner, as it will exceed the permissible limit");
            return -1;
        }
        tonerPercentage += tonerAmount;
        return this.tonerPercentage;
    }

    public int printPages(int pagesToPrint){
        int sheetsToBeConsumed = 0;
        if(duplex) {
            System.out.println("Printing in duplex mode");
            sheetsToBeConsumed = (int) Math.ceil(pagesToPrint/2);
        }
        if (this.tonerPercentage < (sheetsToBeConsumed / 10)) {
            sheetsToBeConsumed = tonerPercentage * 10;
            System.out.println("The number of sheets that could be printed is: " + sheetsToBeConsumed +
                    " because printer ran out of toner ... ");
            setTonerPercentage(this.tonerPercentage - this.tonerPercentage);
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


  /*  private int tonerLevel;
    private boolean duplex;
    private int pagesPrinted;

    public Printer(int tonerLevel, boolean duplex) {
        this.duplex = duplex;
        this.pagesPrinted = 0;
        this.tonerLevel = (tonerLevel>=0 && tonerLevel <= 100) ? tonerLevel: -1;


    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if(this.tonerLevel + tonerAmount > 100) {
                System.out.println("Cannot add this much to toner, as it will exceed the permissible limit");
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;

        } else {
            return -1;
        }
    }

    public int printPages(int pagesToPrint){
        int sheetsToBeConsumed = pagesToPrint;
        if(duplex) {
            System.out.println("Printing in duplex mode");
            //sheetsToBeConsumed = (int) Math.ceil(pagesToPrint/2);
            sheetsToBeConsumed = (pagesToPrint / 2) + (pagesToPrint % 2);
        }
        this.pagesPrinted += sheetsToBeConsumed;

        return sheetsToBeConsumed;

    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }*/
}

