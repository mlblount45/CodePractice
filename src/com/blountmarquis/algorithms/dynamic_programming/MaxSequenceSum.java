package com.blountmarquis.algorithms.dynamic_programming;

/**
 * Created by MLBlount on 8/16/2015.
 */
public class MaxSequenceSum {

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

    public static int getMaxSequenceSum2(int[] arr) {
        if(arr == null) throw new IllegalArgumentException("array can't be null");

        final int n = arr.length;
        int[] sums = new int[n];
        sums[0]= arr[0];


        for (int i = 1; i < n; i++) {
            sums[i] = Math.max((sums[i-1] + arr[i]), arr[i]);
        }
        return sums[n-1];
    }
    public static void main(String[] args) {
        int[] array = new int[]{2,3,-7,5,1,3,-9};
        System.out.println(getMaxSequenceSum(array));
    }
}
