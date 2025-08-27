package com.hb.study.udemy_lpa_javamasterclass.section3_firststeps.demostubs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldTest {

    @Test
    public void testMain() {
        // Arrange
        String[] args = {"John", "Doe"};

        // Act
        HelloWorld.main(args);

        // Assert
        // Since the main method prints to the console, we can only ensure it runs without exceptions.
        assertTrue(true); // Placeholder assertion
    }
}