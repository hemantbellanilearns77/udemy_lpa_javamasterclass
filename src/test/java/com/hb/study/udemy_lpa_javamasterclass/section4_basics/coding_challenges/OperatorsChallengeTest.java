package com.hb.study.udemy_lpa_javamasterclass.section4_basics.coding_challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsChallengeTest {

    private static final double EPSILON = 1e-9;

    @Test
    void testCalculateTotal() {
        double total = OperatorsChallenge.calculateTotal(20.0, 80.0);
        assertEquals(10000.0, total, EPSILON,
                "Total should be (20 + 80) * 100 = 10000");
    }

    @Test
    void testRemainderWithDivisor40_58() {
        double total = OperatorsChallenge.calculateTotal(20.0, 80.0);
        double remainder = OperatorsChallenge.calculateRemainder(total, 40.58);

        assertTrue(Math.abs(remainder) > EPSILON,
                "Expected non-zero remainder for divisor 40.58");
    }

    @Test
    void testRemainderWithDivisor29() {
        double total = OperatorsChallenge.calculateTotal(20.0, 80.0);
        double remainder = OperatorsChallenge.calculateRemainder(total, 29.0);

        assertEquals(24.0, remainder, EPSILON,
                "Expected remainder 24 when dividing 10000 by 29");
    }

    @Test
    void testExactDivision() {
        double total = OperatorsChallenge.calculateTotal(20.0, 80.0);
        double remainder = OperatorsChallenge.calculateRemainder(total, 500.0);

        assertEquals(0.0, remainder, EPSILON,
                "Expected no remainder when dividing 10000 by 500");
    }
}
