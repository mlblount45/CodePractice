package com.blountmarquis.algorithms.sorting;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 11/21/2015.
 */
public class CountingSort {

    private static void countingSort(int[] arr,int min, int max) {
        int[] countNums = new int[max - min + 1];
        for(int i: arr) countNums[i - min]++;

        int z = 0;
        for(int i = min; i < max; i++) {
            while(countNums[i - min] > 0){
                arr[z] = i;
                z++;
                countNums[i - min]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,7,5,1,3,9};
        countingSort(array, 1,9);
        PrintableArray.printArray(array);
    }
}
