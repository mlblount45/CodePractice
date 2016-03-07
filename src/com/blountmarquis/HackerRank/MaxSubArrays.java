package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 2/20/2016.
 */
public class MaxSubArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i = 0; i < tests; i++){
            int n = in.nextInt();
            int[] arr = populateArray(in,n);
            System.out.println(getMaxSlice(arr) + " " + getMaxSubSequence(arr));
        }
    }
    private static int[] populateArray(Scanner in, int size) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    private static int getMaxSlice(int[] arr){
        int maxSlice, maxSoFar;
        maxSlice = maxSoFar= arr[0];
        for(int i = 1; i < arr.length; i++){
            maxSoFar = Math.max(arr[i], maxSoFar+arr[i]);
            maxSlice = Math.max(maxSlice, maxSoFar);
        }return maxSlice;
    }

    private static int getMaxSubSequence(int[] arr){
        int maxSubSequence = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > 0) maxSubSequence += arr[i];
            else if(arr[i] < 0 && arr[i] > maxSubSequence)
                maxSubSequence = arr[i];
        }
        return maxSubSequence;
    }
}
