package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/11/2016.
 */
public class WordIntegerConverter {
    @Test
    public void whenConvertingWordToIntegerBackToWordReturnOriginalWord(){
        assertEquals("One", IntegerToWordConverter.toWords(WordToIntegerConverter.toInteger("One")));
    }

    @Test
    public void whenConvertingIntegerToWordBackToIntegerReturnOriginalInteger(){
        assertEquals(21, WordToIntegerConverter.toInteger(IntegerToWordConverter.toWords(21)));
    }
}
