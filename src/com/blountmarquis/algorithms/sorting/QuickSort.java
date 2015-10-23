package com.blountmarquis.algorithms.sorting;

/**
 * Created by MLBlount on 10/12/2014.
 */
public class QuickSort {
    /**
     * In place sort using divide and conquer approach, by partitioning the array into two subarrays then
     * sorting the two halfs independently. Once the subarrays are sorted the whole array is sorted.
     * @param array
     */
    public static void sort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right){ 
        int mid = partition(array, left, right);
        if(left < mid - 1)
            quickSort(array, left, mid-1);
        if(mid < right)
            quickSort(array, mid, right);
    }

    /**
     * <p>Rearrange the array so all elements smaller than the pivot value reside to the left of pivot and
     * all values greater than the pivot value reside to the right of the pivot values.</p>
     * <p>To achieve this, randomly, select the pivot value.
     * While left count is less than or equal to right count repeat the following:
     * Loop starting at the leftmost element increment left index to the next element if and only if left element is less than
     * pivot value else break loop. Loop starting at the rightmost element decrement right index to the prev element if and only if
     * right element is greater than pivot value, else break loop. If left count is less than or equal to right count
     * swap the left element greater than pivot with the right element less than pivot increment left index decrement
     * right index. Return right most left index.</p>
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] array, int left, int right){
        int pivot = (left + right)/2;

        while(left <= right){
            while(array[left] < array[pivot]) left++;
            while(array[right] > array[pivot]) right--;
            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
