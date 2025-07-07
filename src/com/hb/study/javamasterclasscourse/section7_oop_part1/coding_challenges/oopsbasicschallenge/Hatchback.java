package com.hb.study.javamasterclasscourse.section7_oop_part1.coding_challenges.oopsbasicschallenge;

class Hatchback extends Car {
    private String brandName;
    private String carSegment;

    public Hatchback(String name, String size, int currentSpeed, int currentDirection, int numberOfWheels, int maxSpeed, int numberOfGears, int currentlyActivatedGear, String brandName, String carSegment) {
        super(name, size, currentSpeed, currentDirection, numberOfWheels, maxSpeed, numberOfGears, currentlyActivatedGear);
        this.brandName = brandName;
        this.carSegment = carSegment;
    }

    public void move(int speed){
        /*
         Logic of move
         Check if the desiredSpeed is > maxSpeed ; then return saying already at maxSpeed....
         if currentSpeed is less than speed supplied, then call the changeGears method
         update the currentSpeed;
         */


    }

    public void changeGears(int speed){
        /*
        update the currentlyActivatedGear according to a speed slab
         */

    }

    public void stop(){

    }
}
