package com.blountmarquis.kata;

import com.blountmarquis.katas.IntegerToRoman;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by MLBlount on 12/24/2015.
 */
public class IntegerToRomanTest {

    @Test
    public void whenNumberIsZeroThenReturnEmptyString(){
        assertEquals("", IntegerToRoman.getRoman(0));
    }

    @Test
    public void whenNumberIsOneReturnI() {
        assertEquals("I", IntegerToRoman.getRoman(1));
    }

    @Test
    public void whenNumberIsFiveReturnV() {
        assertEquals("V", IntegerToRoman.getRoman(5));
    }

    @Test
    public void whenNumberIsTwoReturnII() {
        assertEquals("II", IntegerToRoman.getRoman(2));
    }

    @Test
    public void whenNumberIs35ReturnXXXV() {
        assertEquals("XXXV", IntegerToRoman.getRoman(35));
    }

    @Test
    public void whenNumberIs1800ReturnRomanMDCCC() {
        assertEquals("MDCCC", IntegerToRoman.getRoman(1800));
    }
}
