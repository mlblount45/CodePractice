package com.blountmarquis.HackerRank.Sorting;

import java.util.Scanner;

/**
 * Created by MLBlount on 3/18/2016.
 *
 * https://www.hackerrank.com/challenges/almost-sorted
 */
public class AlmostSorted {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = buildArray(in, n);
    System.out.println(isAlmostSorted(arr));
  }

  private static String isAlmostSorted(int[] arr) {
    if (isSorted(arr)) {
      return "yes";
    }
    int i = 0, j = arr.length - 1;

    for (; i < j; i++) {
      if (arr[i] > arr[i + 1]) {
        break;
      }
    }
    for (; j > i; j--) {
      if (arr[j] < arr[j - 1]) {
        break;
      }
    }
    swap(arr, i, j);
    if (isSorted(arr)) {
      return "yes \nswap " + (i + 1) + " " + (j + 1);
    }
    swap(arr, i, j);
    reverse(arr, i, j);
    if (isSorted(arr)) {
      return "yes \nreverse " + (i + 1) + " " + (j + 1);
    }
    return "no";
  }

  private static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }

  public static int[] buildArray(Scanner in, int size) {
    in.nextLine();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
