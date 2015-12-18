package com.blountmarquis.InterviewQuestions.arrayManipulation;

import java.util.Arrays;

/**
 * Created by MLBlount on 4/20/2015.
 */
public class MinSlice {
    public static int getKadaneAbsoluteMinSlice(int[] arr){
        int minEnd, minSlice;
        minEnd = minSlice = arr[0];

        for(int i = 1; i < arr.length; i++){
            minEnd = Math.min(arr[0], Math.abs(minEnd + arr[i]));
            minSlice = Math.min(minEnd, minSlice);
        }
        return minSlice;
    }

    public static int getSortedPrefixAbsoluteMinSlice(int[] arr){
        int[] sums = getPrefixSum(arr);
        Arrays.sort(sums);
        return getMinDifference(sums);
    }

    public static int[] getPrefixSum(int[] arr){
        int[] sums = new int[arr.length +  1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i - 1] + arr[i - 1];
        }

        return sums;
    }

    private static int getMinDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        int temp;
        for(int i = 0; i < arr.length - 1; i++){
            temp = Math.abs(arr[i+1] - arr[i]);
            if(temp < min)
                min = temp;
        }
        return min;
    }


    public static void main(String[] args){
        int[] array = new int[]{2,-4,6,-3,9};
        int minSlice = getKadaneAbsoluteMinSlice(array);
        System.out.println("------Final Min Slice-----");
        System.out.println("Min slice is: " + minSlice);
    }
}
