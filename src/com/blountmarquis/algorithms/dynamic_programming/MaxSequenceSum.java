package com.blountmarquis.algorithms.dynamic_programming;

/**
 * Created by MLBlount on 8/16/2015.
 */
public class MaxSequenceSum {

    /*Implementation of Kadane's algorithm of finding max slice*/
    public static int getMaxSequenceSum(int[] arr) {
        if(arr == null) throw new IllegalArgumentException("array can't be null");

        int sum = arr[0];
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
           temp = Math.max((temp + arr[i]), arr[i]);
            sum = Math.max(temp, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, -1 ,2 ,3 ,4, -5};
        System.out.println(getMaxSequenceSum(array));
    }
}
