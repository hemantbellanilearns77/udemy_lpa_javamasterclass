package com.hb.study.udemylpajavamasterclass.section8_oop_part2.exercises.exercise38;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

public class Bed {

     private String style;
     private int pillows;
     private int height;
     private int sheets;
     private int quilt;

     public Bed(String style, int pillows, int height, int sheets, int quilt) {
          this.style = style;
          this.pillows = pillows;
          this.height = height;
          this.sheets = sheets;
          this.quilt = quilt;
     }


     public String getStyle() {
          return style;
     }

     public int getPillows() {
          return pillows;
     }

     public int getHeight() {
          return height;
     }

     public int getSheets() {
          return sheets;
     }

     public int getQuilt() {
          return quilt;
     }

     public void make() {
          ConsoleStyler.styleOutput("the bed is being made");
     }
}
