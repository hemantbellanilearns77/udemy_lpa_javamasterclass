package com.hb.study.udemy_lpa_javamasterclass.global.utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * created by : heman on 01-09-2025, 01:01 pm, in the "run-pmd.bat" project
 **/
public class SimpleConsoleOutputFormatter extends Formatter {//Object level or Static declarations here...

    @Override
    public String format(LogRecord record) {
        return record.getMessage() + System.lineSeparator();
    }
}
