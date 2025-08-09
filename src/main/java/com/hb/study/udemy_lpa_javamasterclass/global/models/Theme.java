package com.hb.study.udemy_lpa_javamasterclass.global.models;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.BackgroundColor;
import com.hb.study.udemy_lpa_javamasterclass.global.constants.ForegroundColor;

import java.util.ArrayList;
import java.util.List;

/**
 * created by : heman on 21-07-2025, 05:39 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class Theme {
    public void setBg(BackgroundColor bg) {
        this.bg = bg;
    }

    public void setFg(ForegroundColor fg) {
        this.fg = fg;
    }

    public void setFormattingElements(List<String> formattingElements) {
        this.formattingElements = formattingElements;
    }

    public void setHasFormattingElements(boolean hasFormattingElements) {
        this.hasFormattingElements = hasFormattingElements;
    }

    //Object level or Static declarations here...
    private BackgroundColor bg;
    private ForegroundColor fg;
    private List<String> formattingElements;
    private boolean hasFormattingElements;

    public BackgroundColor getBg() {
        return bg;
    }

    public ForegroundColor getFg() {
        return fg;
    }

    public List<String> getFormattingElements() {
        return formattingElements;
    }

    public boolean isHavingFormattingElements() {
        return hasFormattingElements;
    }

    public Theme(BackgroundColor bg, ForegroundColor fg, List<String> formattingElements) {
        this.bg = bg;
        this.fg = fg;
        if(formattingElements != null) {
            this.formattingElements = new ArrayList<>(formattingElements);
        } else {
            this.formattingElements = null;
        }
        this.hasFormattingElements = (this.formattingElements!=null && !this.formattingElements.isEmpty());
    }

     
    public String getCombinedAnsi() {
        return bg.getAnsiCode() + fg.getAnsiCode();
    }
}
