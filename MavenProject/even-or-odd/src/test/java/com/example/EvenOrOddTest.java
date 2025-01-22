package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EvenOrOddTest {

    // Test case for even number
    @Test
    public void testEvenNumber() {
        // Call the method and check the result for an even number
        assertEquals("Even", EvenOrOdd.checkEvenOrOdd(4));
    }

    // Test case for odd number
    @Test
    public void testOddNumber() {
        // Call the method and check the result for an odd number
        assertEquals("Odd", EvenOrOdd.checkEvenOrOdd(5));
    }

    // Test case for zero (even number)
    @Test
    public void testZero() {
        // Call the method and check the result for zero, which is an even number
        assertEquals("Even", EvenOrOdd.checkEvenOrOdd(0));
    }

    // Test case for negative even number
    @Test
    public void testNegativeEvenNumber() {
        // Call the method and check the result for a negative even number
        assertEquals("Even", EvenOrOdd.checkEvenOrOdd(-6));
    }

    // Test case for negative odd number
    @Test
    public void testNegativeOddNumber() {
        // Call the method and check the result for a negative odd number
        assertEquals("Odd", EvenOrOdd.checkEvenOrOdd(-5));
    }
}