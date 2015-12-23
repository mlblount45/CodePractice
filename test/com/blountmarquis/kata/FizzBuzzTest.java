package com.blountmarquis.kata;

import com.blountmarquis.katas.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MLBlount on 12/22/2015.
 */
public class FizzBuzzTest {

    @Test
    public void whenNumberIsNotDivisibleByThreeOrFiveReturnNumber(){
        Assert.assertEquals("1", FizzBuzz.getFizzBuzzResponse(1));
    }

    @Test
    public void whenNumberIsThreeThenReturnFizz(){
        assertEquals("Fizz", FizzBuzz.getFizzBuzzResponse(3));
    }

    @Test
    public void whenNumberIsFiveThenReturnBuzz(){
        assertEquals("Buzz", FizzBuzz.getFizzBuzzResponse(5));
    }

    @Test
    public void whenNumberIsDivisibleByThreeThenReturnFizz(){
        assertEquals("Fizz", FizzBuzz.getFizzBuzzResponse(6));
    }

    @Test
    public void whenNumberIsDivisibleByFiveThenReturnBuzz(){
        assertEquals("Buzz", FizzBuzz.getFizzBuzzResponse(10));
    }

    @Test
    public void whenNumberIsDivisibleByThreeAndFiveThenReturnFizzBuzz(){
        assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzResponse(15));
    }

    @Test
    public void whenNumberIsMaxIntThenReturnMaxInt(){
        assertEquals(Integer.MAX_VALUE + "", FizzBuzz.getFizzBuzzResponse(Integer.MAX_VALUE));
    }

    @Test
    public void whenNumberIsMinIntThenReturnMinInt(){
        assertEquals(Integer.MIN_VALUE + "", FizzBuzz.getFizzBuzzResponse(Integer.MIN_VALUE));
    }

    @Test
    public void whenNumberIsNegativeAndDivisibleByThreeThenReturnFizz(){
        assertEquals("Fizz", FizzBuzz.getFizzBuzzResponse(-18));
    }

    @Test
    public void whenNumberIsNegativeAndDivisibleByFiveThenReturnBuzz(){
        assertEquals("Buzz", FizzBuzz.getFizzBuzzResponse(-20));
    }

    @Test
    public void whenNumberIsNegativeAndDivisibleByThreeAndFiveThenReturnFizzBuzz(){
        assertEquals("FizzBuzz", FizzBuzz.getFizzBuzzResponse(-30));
    }

    @Test
    public void whenNumberIsZeroThenReturnZero(){
        assertEquals("0", FizzBuzz.getFizzBuzzResponse(0));
    }
}
