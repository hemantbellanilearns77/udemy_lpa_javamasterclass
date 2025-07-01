package com.hb.study.udemy.lpa.section7_oop_part1.exercises.exercise30;

public class SimpleCalculator {

    private double firstNumber;
    private double secondNumber;

    public double getAdditionResult(){
        return getFirstNumber() + getSecondNumber();
    }

    public double getSubtractionResult (){
        return getFirstNumber() - getSecondNumber();
    }

    public double getMultiplicationResult() {
       return getFirstNumber() * getSecondNumber();
    }

    public double getDivisionResult(){
        if(getSecondNumber() == 0.0){
            return 0.0;
        }
        return getFirstNumber() / getSecondNumber();
    }
    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }





}
