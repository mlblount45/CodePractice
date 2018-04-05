package com.blountmarquis.LeetCode;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 7/2/2015.
 */
public class LeetCode_FirstMissingPositive {

  public static void main(String[] args) {
    LeetCode_FirstMissingPositive missing = new LeetCode_FirstMissingPositive();
    int[] arr = new int[]{-1, 4, 2, 1, 9, 10};
    System.out.println("Missing positive: " + missing.firstMissingPositive(arr));
  }

  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }

    int j = 0;
    while (j < n && nums[j] == j + 1) {
      j++;
    }
    PrintableArray.printArray(nums);
    return j + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
