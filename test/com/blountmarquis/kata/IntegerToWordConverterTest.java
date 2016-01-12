package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/11/2016.
 */
public class IntegerToWordConverterTest {
    @Test
    public void whenIntegerIs0ThenReturnZero(){
        assertEquals("Zero", IntegerToWordConverter.toWords(0));
    }

    @Test
    public void whenIntegerIs1ThenReturnOne(){
        assertEquals("One", IntegerToWordConverter.toWords(1));
    }

    @Test
    public void whenIntegerIs11ThenReturnEleven(){
        assertEquals("Eleven", IntegerToWordConverter.toWords(11));
    }

    @Test
    public void whenIntegerIs20ThenReturnEleven(){
        assertEquals("Twenty", IntegerToWordConverter.toWords(20));
    }

    @Test
    public void whenIntegerIs21ThenReturnTwentyOne(){
        assertEquals("Twenty One", IntegerToWordConverter.toWords(21));
    }

    @Test
    public void whenIntegerIs100ThenReturnOneHundred(){
        assertEquals("One Hundred", IntegerToWordConverter.toWords(100));
    }

    @Test
    public void whenIntegerIs1000ThenReturnOneThousand(){
        assertEquals("One Thousand", IntegerToWordConverter.toWords(1000));
    }

    @Test
    public void whenIntegerIs10000ThenReturnTenThousand(){
        assertEquals("Ten Thousand", IntegerToWordConverter.toWords(10000));
    }

    @Test
    public void whenIntegerIs1000000ThenReturnOneMillion(){
        assertEquals("One Million", IntegerToWordConverter.toWords(1000000));
    }

    @Test
    public void whenIntegerIs1000000000ThenReturnOneBillion(){
        assertEquals("One Billion", IntegerToWordConverter.toWords(1000000000));
    }

    @Test
    public void whenIntegerIs1000000ThenReturnOneBillion(){
        assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety", IntegerToWordConverter.toWords(1234567890));
    }
}
