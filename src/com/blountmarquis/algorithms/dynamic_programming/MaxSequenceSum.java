package com.blountmarquis.algorithms.dynamic_programming;

import java.util.Scanner;

/**
 * Created by MLBlount on 8/16/2015.
 */
public class MaxSequenceSum {

    /**
     * Notice this is a modified implementation of Kadane's algorithm of finding max slice.
     * in this implementation the max sum no longer needs to be continues e.g the sum
     * of [2 -1 2 3 4 -5] is 11 for max sub sequence. The algorithm takes the following steps
     * on each iteration. Each iteration will either leave the existing sum unchanged, add to the existing sum,
     * or set the existing sum equal to the current iteration value.
     * @param arr
     * @return
     */
    public static int getMaxSubSequenceSum(int[] arr) {
        if(arr == null) throw new IllegalArgumentException("array can't be null");

        int maxSubSequence = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSubSequence = Math.max(maxSubSequence,maxSubSequence + arr[i]);
            maxSubSequence = Math.max(arr[i], maxSubSequence);
        }
        return maxSubSequence;
    }

    private static int[] populateArray(Scanner in, int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i = 0; i < tests; i++){
            int n = in.nextInt();
            int[] arr = populateArray(in,n);
            System.out.println(getMaxSubSequenceSum(arr));
        }
    }
}
