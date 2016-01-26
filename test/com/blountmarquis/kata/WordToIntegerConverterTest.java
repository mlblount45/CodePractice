package com.blountmarquis.kata;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/11/2016.
 */
public class WordToIntegerConverterTest {


    @Test
    public void whenWordIsEmptyTextThenReturn0(){
        assertEquals(0, WordToIntegerConverter.toInteger(""));
    }

    @Test
    public void whenWordIsZeroThroughNineReturnIntegerConversion(){
        HashMap<Integer, String> lookup = new HashMap<Integer, String>(){{
            put(0,"Zero");put(1,"One");put(2,"Two");put(3,"Three");put(4,"Four");put(5,"Five");
            put(6,"Six");put(7,"Seven");put(8,"Eight");put(9,"Nine");
        }};
        for(int i = 0; i < 10; i++) {
            assertEquals(i, WordToIntegerConverter.toInteger(lookup.get(i)));
        }
    }

    @Test
    public void whenWordIsTenThroughNineteenReturnIntegerConversion(){
        HashMap<Integer, String> lookup = new HashMap<Integer, String>(){{
            put(10,"Ten");put(11,"Eleven");put(12,"Twelve");put(13,"Thirteen");put(14,"Fourteen");put(15,"Fifteen");
            put(16,"Sixteen");put(17,"Seventeen");put(18,"Eighteen");put(19,"Nineteen");
        }};
        for(int i = 10; i < 20; i++) {
            assertEquals(i, WordToIntegerConverter.toInteger(lookup.get(i)));
        }
    }


    @Test
    public void whenWordIsTwentyThroughNinetyReturnIntegerConversion(){
        HashMap<Integer, String> lookup = new HashMap<Integer, String>(){{
            put(20,"Twenty");put(30,"Thirty");put(40,"Forty");put(50,"Fifty");put(60,"Sixty");put(70,"Seventy");
            put(80,"Eighty");put(90,"Ninety");
        }};
        for(int i = 20; i < 100; i+=10) {
            assertEquals(i, WordToIntegerConverter.toInteger(lookup.get(i)));
        }
    }

    @Test
    public void whenWordIsOneHundredThenReturn100(){
        assertEquals(100, WordToIntegerConverter.toInteger("One Hundred"));
    }

    @Test
    public void whenWordIsOneHundredThirtyThreeThenReturn133(){
        assertEquals(133, WordToIntegerConverter.toInteger("One Hundred Thirty Three"));
    }


    @Test
    public void whenWordIsOneThousandOneHundredReturn1100(){
        assertEquals(1100, WordToIntegerConverter.toInteger("One Thousand One Hundred"));
    }

    @Test
    public void whenWordIsFourThousandThenReturn4000(){
        assertEquals(4000, WordToIntegerConverter.toInteger("Four Thousand"));
    }

    @Test
    public void whenWordIsFiveMillionThenReturn5000000(){
        assertEquals(5000000, WordToIntegerConverter.toInteger("Five Million"));
    }

    @Test
    public void whenWordIsOneBillionThenReturn1000000000(){
        assertEquals(1000000000, WordToIntegerConverter.toInteger("One Billion"));
    }
}
