package com.hb.study.udemy_lpa_javamasterclass.section8_oop_part2.exercises.exercise38;

public class Ceiling {

    private final int height;
    private final int paintedColor;

    public Ceiling(int height, int paintedColor) {
        this.height = height;
        this.paintedColor = paintedColor;
    }

    private int getHeight(){
        return this.height;
    }

    public int getPaintedColor(){
            return this.paintedColor;
    }
    @Override
    public String toString() {
        return "Ceiling{" +
                "height=" + getHeight() +
                ", paintedColor=" + getPaintedColor() +
                '}';
    }
}
