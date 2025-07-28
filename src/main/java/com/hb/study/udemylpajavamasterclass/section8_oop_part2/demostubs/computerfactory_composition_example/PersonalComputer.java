package com.hb.study.udemylpajavamasterclass.section8_oop_part2.demostubs.computerfactory_composition_example;

class PersonalComputer extends Product{

    private String model;
    private String manufacturer;
    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;

     public PersonalComputer(String model,
                            String manufacturer,
                            ComputerCase computerCase,
                            Monitor monitor,
                            Motherboard motherboard
                            ) {
        super(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;

    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                super.toString() +
                ", \n monitor=" + monitor.toString() +
                ", \n motherboard=" + motherboard.toString() +
                ", \n computerCase=" + computerCase.toString() +
                "} " ;
    }

    /*public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public ComputerCase getComputerCase() {
        return computerCase;
    }*/

    public void powerUp(){
        computerCase.pressPowerButton();
        motherboard.loadProgram("Operating System");
        drawLogo();
    }
    private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "yellow");
    }
}
