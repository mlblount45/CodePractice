package com.blountmarquis.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlblount on 1/24/2016.
 */
public class HammingTest {

    @Test
    public void whenHamming1ThenReturn1(){
        assertHammingCalculation(1, 1);
    }

    @Test
    public void whenHamming2ThenReturn2(){
        assertHammingCalculation(2, 2);
    }


    @Test
    public void whenHamming3ThenReturn3(){
        assertHammingCalculation(3, 3);
    }

    @Test
    public void whenHamming5ThenReturn5(){
        assertHammingCalculation(5, 5);
    }

    @Test
    public void whenHamming6ThenReturn6(){
        assertHammingCalculation(6, 6);
    }

    @Test
    public void whenHamming1692ThenReturn2147483648(){
        assertHammingCalculation(2147483648L, 1692);
    }


    private void assertHammingCalculation(long expected, int n) {
        assertEquals(expected, Hamming.hamming(n));
    }



}
