package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;


import com.hblearns77.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

class ComputerCase extends Monitor{

    private String powerSupply;


    public ComputerCase(String model, String manufacturer) {
        super(model,manufacturer);
    }
    public ComputerCase(String model, String manufacturer,
                        String powerSupply) {
        super(model,manufacturer);
        this.powerSupply = powerSupply;
    }

    public void pressPowerButton(){
        ConsoleStyler.styleOutput("Power Button Pressed....");
    }

    @Override
    public String toString() {
        return "ComputerCase{" +
                super.toString() +
                "powerSupply='" + powerSupply + '\'' +
                "} ";
    }
}
