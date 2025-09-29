package com.hb.study.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxNumberChallengeTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    void testMinMaxWithMultipleNumbers() {
        // simulate user entering numbers 5.5, 2.2, 9.9 then exit
        provideInput("5.5\n2.2\n9.9\nexit\n");

        MinMaxNumberChallenge.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("The minimum number is: 2.2"));
        assertTrue(output.contains("The maximum number is: 9.9"));
        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 3"));
    }

    @Test
    void testSingleNumber() {
        provideInput("7.7\nexit\n");

        MinMaxNumberChallenge.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("The minimum number is: 7.7"));
        assertTrue(output.contains("The maximum number is: 7.7"));
        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 1"));
    }

    @Test
    void testNonDecimalInput() {
        provideInput("3.3\nabc\n");

        MinMaxNumberChallenge.main(new String[]{});

        String output = getOutput();
        assertTrue(output.contains("Since you entered a non-decimal number character, so exiting"));
    }
}
