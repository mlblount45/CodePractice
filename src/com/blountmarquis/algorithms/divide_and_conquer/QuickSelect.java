package com.blountmarquis.algorithms.divide_and_conquer;

import java.util.Random;

/**
 * Created by mlblount on 8/22/2015.
 */

/**
 * <p>Select <i>Ith Order Statistic</i> element in array in O(n) expected time O(n^2) worst case. Using QuickSort partition method
 * partition array around random pivot index on each call. Partitioned array will contain the <i>Ith Order Statistic </i>
 * element in 1 or 3 location, 1) if pivot equal <i>Ith Order Statistic</i> return pivot. 2) <i>Ith Order Statistic </i>
 * is on the left side of the partitioned array so traverse left side of the array. 3) <i>Ith Order Statistic </i> is on
 * the right side of the partitioned array, so traverse the right side of the array and subtract pivot index (lets call
 * this <i>k</i> from <i>i</i>. This is because the pivot index has gotten you closer to <i>Ith Order Statistic</i>.
 * Now that your previous pivot index will be the new start element of your traversal reducing <i>i</i> by <i>k</i> sets
 * up the next level of traversal with the correct values. </p>
 */
public class QuickSelect {

    public static int selectIthSmallest(int[] arr, int k) {
        if (k < 1 || arr.length == 0 || k > arr.length)
            throw new IllegalArgumentException("WTF: array must have at least 1 element and k must be greater than or equal to 1 and less than array length");
        return selectIthSmallest(arr, 0, arr.length - 1, k);
    }

    private static int selectIthSmallest(int[] arr, int start, int end, int i) {
        if (start == end) return arr[start];
        int mid = partition(arr, start, end);
        int k = mid - start + 1;
        if (i == k) return arr[mid];

        if (start < mid - 1 && i < k) return selectIthSmallest(arr, start, mid - 1, i);
        else return selectIthSmallest(arr, mid + 1, end, i - k);
    }


    private static int partition(int[] arr, int start, int end) {
        int pivotIndex = rand(start, end);
        int pivot = arr[pivotIndex];
        swap(arr, end, pivotIndex);
        pivotIndex = end;
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, pivotIndex);
        return i + 1;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static int rand(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    public static void main(String[] args) {                         //1  2  3  4  5  6  7   8   9  10
        int array[] = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1}; //=> 1, 2, 3, 4, 7, 8, 9, 10, 14, 16
        System.out.println("kth smallest number is: " + QuickSelect.selectIthSmallest(array, 8));
    }
}
