package com.blountmarquis.sd_meetup;

/**
 * Created by MLBlount on 8/2/2015.
 */
public class MaxDifferencePair {

  public static int getMaxDifferencePair(int[] arr) {
    if (arr == null || arr.length < 2) {
      throw new IllegalArgumentException("WTF is this");
    }

    int maxDifference = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] - arr[j] > maxDifference) {
          maxDifference = arr[i] - arr[j];
        }
      }
    }

    return maxDifference;
  }

  public static void main(String[] args) {
    System.out.println("Max difference is: " + MaxDifferencePair
        .getMaxDifferencePair(new int[]{2, 4, 1, 16, 7, 5, 11, 9}));
  }
}
