package com.blountmarquis.algorithms.divide_and_conquer;

/**
 * Created by mlblount on 8/22/2015.
 */

/*
   NOT Implemented correctly a few off by one bugs causing incorrect outputs
 */
    @Deprecated
public class OrderStatistic {

    public static int selectIthSmallest(int [] arr, int i){
        if(i < 1 || arr.length == 0)
            throw new IllegalArgumentException("WTF: array must have atleast 1 value and i must be greater than or equal to 1");
        return selectIthSmallest(arr, 0, arr.length - 1, i);
    }

    private static int selectIthSmallest(int[] arr, int left, int right, int i) {

        int mid = partition(arr, left, right);

        int k = mid - left;
        if(k == i) return arr[mid];
        if(i < k) return selectIthSmallest(arr, left, k, i);
        else return selectIthSmallest(arr, k, right, i - k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while(left <= right){
            while(left < arr.length && arr[left] < pivot) left++;
            while(right >=0 && arr[right] > pivot) right--;
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }


    public static void main(String[] args){
        int array[] = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1}; //=> 1, 2, 3, 4, 7, 8, 9, 10, 14, 16
        System.out.println("5th largest number is: " + OrderStatistic.selectIthSmallest(array,6));
    }
}
