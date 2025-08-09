package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.demostubs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {

    @Test
    void testMainWithArgs() {
        String[] args = {"Jane", "Doe"};
        assertDoesNotThrow(() -> HelloWorld.main(args));
    }
}