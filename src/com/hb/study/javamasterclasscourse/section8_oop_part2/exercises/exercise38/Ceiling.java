package com.hb.study.javamasterclasscourse.section8_oop_part2.exercises.exercise38;

public class Ceiling {

    private int height;
    private int paintedColor;

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
}
