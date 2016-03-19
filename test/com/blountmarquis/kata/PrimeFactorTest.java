package com.blountmarquis.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by MLBlount on 1/21/2016.
 */
public class PrimeFactorTest {


    @Test
    public void whenOneThenReturnEmptyArray(){
        assertEquals(getArray(), PrimeFactor.generate(1));
    }

    @Test
    public void whenTwoThenReturnArrayContainingValTwo(){
        assertEquals(getArray(2), PrimeFactor.generate(2));
    }

    @Test
    public void whenThreeThenReturnArrayContainingValThree(){
        assertEquals(getArray(3), PrimeFactor.generate(3));
    }

    @Test
    public void whenFourThenReturnArrayContainingTwoTwoVals(){
        assertEquals(getArray(2,2), PrimeFactor.generate(4));
    }

    @Test
    public void whenSixThenReturnArrayContainingTwoAndThree(){
        assertEquals(getArray(2,3), PrimeFactor.generate(6));
    }

    @Test
    public void whenFiveThenReturnArrayContainingFive(){
        assertEquals(getArray(5), PrimeFactor.generate(5));
    }

    @Test
    public void whenEightThenReturnArrayContainingThreeTwos(){
        assertEquals(getArray(2,2,2), PrimeFactor.generate(8));
    }

    private List<Integer> getArray(int... ints) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < ints.length; i++)
            nums.add(ints[i]);
        return nums;
    }

}
