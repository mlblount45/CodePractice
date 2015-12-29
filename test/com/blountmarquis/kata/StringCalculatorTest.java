package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MLBlount on 12/29/2015.
 */
public class StringCalculatorTest {
    @Test
    public void whenInputStringEmptyThenReturnZero() {
        assertEquals(0, StringCalculator.calculate(""));
    }
}
