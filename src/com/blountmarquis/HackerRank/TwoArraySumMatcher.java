package com.blountmarquis.HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by mlblount on 2/18/2016.
 */
public class TwoArraySumMatcher {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int test = in.nextInt();

    for (int i = 0; i < test; i++) {
      int size = in.nextInt();
      int target = in.nextInt();
      in.nextLine();
      Integer[] arr1 = populateArray(in, size);
      Integer[] arr2 = populateArray(in, size);
      System.out.println(isTargetedPairExist(arr1, arr2, target));
    }
  }

  private static String isTargetedPairExist(Integer[] arr1, Integer[] arr2, int target) {
    Arrays.sort(arr1);
    Arrays.sort(arr2, new DescendingComparator());
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] + arr2[i] < target) {
        return "NO";
      }
    }
    return "YES";
  }


  private static Integer[] populateArray(Scanner in, int size) {
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  private static class DescendingComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  }
}
