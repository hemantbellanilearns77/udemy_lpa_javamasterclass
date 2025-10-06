package com.hblearns77.udemy_lpa_javamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

class PersonalComputer extends Product{

    private String model;
    private final String manufacturer;
    private final Monitor monitor;
    private final Motherboard motherboard;
    private final ComputerCase computerCase;

     public PersonalComputer(String model,
                             String manufacturer,
                             ComputerCase computerCase,
                             Monitor monitor,
                             Motherboard motherboard
                            ) {
        super(model, manufacturer);
         this.model = model;
         this.manufacturer = manufacturer;
         this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;

    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", monitor=" + monitor +
                ", motherboard=" + motherboard +
                ", computerCase=" + computerCase +
                '}';
    }

    public void powerUp(){
        computerCase.pressPowerButton();
        motherboard.loadProgram("Operating System");
        drawLogo();
    }
    private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
