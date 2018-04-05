package com.blountmarquis.algorithms.divideandconqure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.blountmarquis.algorithms.divideandconquer.BinarySearch;

/**
 * Created by MLBlount on 12/23/2015.
 */

public class BinarySearchTest {

    @Test
    public void whenArrayIsEmptyReturnNegativeOne(){
        assertEquals(-1, getIndex(new int[0], 0));
    }

    @Test
    public void whenTargetAtFirstElementReturnElementZero() {
        assertEquals(0, getIndex(new int[]{1}, 1));
    }

    @Test
    public void whenTargetNotInArrayReturnNegativeOne1() {
        assertEquals(-1, getIndex(new int[]{1}, 0));
    }

    @Test
    public void whenTargetNotInArrayReturnNegativeOne2() {
        assertEquals(-1, getIndex(new int[]{1, 2, 3}, 4));
    }

    @Test
    public void whenTargetAtMidPointOfArrayOfSizeThreeReturnIndexOne() {
        assertEquals(1, getIndex(new int[]{1, 2, 3}, 2));
    }

    @Test
    public void whenTargetAtMidpointOfUpperHalfOfArrayOfSizeThreeReturnIndexTwo() {
        assertEquals(2, getIndex(new int[]{1, 2, 3}, 3));
    }

    @Test
    public void whenTargetAtMidpointOfLowerHalfOfArrayOfSizeThreeReturnIndexZero() {
        assertEquals(0, getIndex(new int[]{1, 2, 3}, 1));
    }

    @Test
    public void when() {
        //LocalDate
    }
    private int getIndex(int[] nums, int target) {
        return BinarySearch.findIndex(nums, target);
    }

}
