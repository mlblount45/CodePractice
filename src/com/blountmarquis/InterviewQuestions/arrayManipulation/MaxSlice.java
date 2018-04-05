package com.blountmarquis.InterviewQuestions.arrayManipulation;

/**
 * Created by MLBlount on 4/12/2015.
 */
public class MaxSlice {

  /**
   * This algorithm is a modification of Kadane's algorithm where as this algorithm can return a negative max value
   */
  public static int getMaxSlice(int[] arr) {
    int maxEnd = arr[0];
    int maxSlice = arr[0];
    for (int i = 1; i < arr.length; i++) {
      maxEnd = Math.max(arr[i], maxEnd + arr[i]);
      maxSlice = Math.max(maxEnd, maxSlice);

    }
    return maxSlice;
  }

  public static void main(String[] args) {
    int[] array = new int[]{2, -1, 2, 3, 4, -5};
    int maxSlice = getMaxSlice(array);
    System.out.println("------Final Max Slice-----");
    System.out.println("Max slice is: " + maxSlice);
  }
}


