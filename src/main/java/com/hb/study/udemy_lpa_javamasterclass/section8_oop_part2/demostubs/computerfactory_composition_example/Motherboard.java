package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

 import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;
class Motherboard extends Monitor{
    private int ramSlots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufacturer) {
        super(model,manufacturer);
    }

    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        super(model, manufacturer);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String nameOFProgram) {
        ConsoleStyler.styleOutput("Program Loading..... : "+ nameOFProgram);
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                super.toString() +
                "ramSlots=" + ramSlots +
                ", cardSlots=" + cardSlots +
                ", bios='" + bios + '\'' +
                "} " + super.toString();
    }
}
