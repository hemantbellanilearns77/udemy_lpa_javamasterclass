package com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges;

import com.hblearns77.udemy_lpa_javamasterclass.section6_controlflow.coding_challenges.MinMaxNumberChallenge;
import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxNumberChallengeTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private String runWithInput(String input) {
        InputStream originalIn = System.in;
        try (InputStream testIn = new ByteArrayInputStream(input.getBytes())) {
            System.setIn(testIn);
            MinMaxNumberChallenge.main(new String[]{});
            return outputStreamCaptor.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.setIn(originalIn);
        }
    }


    @Test
    void testSingleNumberThenExit() {
        String input = "5.5\nexit\n";
        String output = runWithInput(input);

        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 1"));
        assertTrue(output.contains("The minimum number is: 5.5"));
        assertTrue(output.contains("The maximum number is: 5.5"));
    }

    @Test
    void testMultipleNumbers() {
        String input = "10.1\n3.2\n7.8\nexit\n";
        String output = runWithInput(input);

        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 3"));
        assertTrue(output.contains("The minimum number is: 3.2"));
        assertTrue(output.contains("The maximum number is: 10.1"));
    }

    @Test
    void testInvalidInputTriggersExit() {
        String input = "4.4\nabc\n";
        String output = runWithInput(input);

        assertTrue(output.contains("Since you entered a non-decimal number character, so exiting"));
        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 1"));
        assertTrue(output.contains("The minimum number is: 4.4"));
        assertTrue(output.contains("The maximum number is: 4.4"));
    }

    @Test
    void testNoNumbersJustExit() {
        String input = "exit\n";
        String output = runWithInput(input);

        assertTrue(output.contains("The count of decimal numbers screened to come to max and min values is: 0"));
        assertTrue(output.contains("The minimum number is: 0.0"));
        assertTrue(output.contains("The maximum number is: 0.0"));
    }
}
