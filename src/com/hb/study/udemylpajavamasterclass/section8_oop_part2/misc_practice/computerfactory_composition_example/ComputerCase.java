package com.hb.study.udemylpajavamasterclass.section8_oop_part2.misc_practice.computerfactory_composition_example;

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
        System.out.println("Power Button Pressed....");
    }

    @Override
    public String toString() {
        return "ComputerCase{" +
                super.toString() +
                "powerSupply='" + powerSupply + '\'' +
                "} ";
    }
}
