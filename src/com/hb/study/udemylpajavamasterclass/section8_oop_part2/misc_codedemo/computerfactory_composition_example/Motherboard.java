package com.hb.study.udemylpajavamasterclass.section8_oop_part2.misc_codedemo.computerfactory_composition_example;

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
        System.out.println("Program Loading..... : "+ nameOFProgram);
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
