package com.blountmarquis.algorithms.sorting;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/2/2014.
 */
public class InsertionSort extends PrintableArray {

    public static void sort(int[] array) {
        if (array == null) return;
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    public static void insertionSortAlternative(int[] arr) {
        if (arr == null) return;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 7, 5, 1, 3, 9};
        insertionSortAlternative(array);
        PrintableArray.printArray(array);
    }
}
