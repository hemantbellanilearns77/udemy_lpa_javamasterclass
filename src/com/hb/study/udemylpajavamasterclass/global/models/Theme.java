package com.hb.study.udemylpajavamasterclass.global.models;

import com.hb.study.udemylpajavamasterclass.global.constants.BackgroundColor;
import com.hb.study.udemylpajavamasterclass.global.constants.ForegroundColor;
import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.List;
import java.util.Random;

/**
 * created by : heman on 21-07-2025, 05:39 pm, in the "udemy_lpa_javamasterclass" project
 **/
public class Theme {
    //Object level or Static declarations here...
    public final BackgroundColor bg;
    public final ForegroundColor fg;
    public final List<String> formattingElements;
    public final boolean hasFormattingElements;

    public BackgroundColor getBg() {
        return bg;
    }

    public ForegroundColor getFg() {
        return fg;
    }

    public List<String> getFormattingElements() {
        return formattingElements;
    }

    public boolean isHavingFormattingELements() {
        return hasFormattingElements;
    }

    public Theme(BackgroundColor bg, ForegroundColor fg, List<String> formattingElements) {
        this.bg = bg;
        this.fg = fg;
        hasFormattingElements = (formattingElements != null && !formattingElements.isEmpty());
        this.formattingElements = formattingElements;
    }

    private static final int maxElementAndIterationCount = new Random().nextInt(1, (63 + 1));
    public String getCombinedAnsi() {
        return bg.getAnsiCode() + fg.getAnsiCode();
    }
}
