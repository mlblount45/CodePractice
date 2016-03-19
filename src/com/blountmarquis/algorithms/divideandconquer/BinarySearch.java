package com.blountmarquis.algorithms.divideandconquer;

/**
 * Created by MLBlount on 12/23/2015.
 */
public class BinarySearch {

    public static int findIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
