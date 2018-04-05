package com.blountmarquis.algorithms.sorting;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/4/2014.
 */
public class MergeSort extends PrintableArray {

  public static void sort(int[] array) {
    if (array == null) {
      return;
    }
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int middle = (start + end) / 2;
    sort(array, start, middle);
    sort(array, middle + 1, end);
    merge(array, start, middle, end);
  }

  private static void merge(int[] array, int start, int middle, int end) {
    int n1 = middle - start + 1;
    int n2 = end - middle;

    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++) {
      left[i] = array[start + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = array[middle + i + 1];
    }

    int i = 0;
    int j = 0;

    for (int k = start; k <= end; k++) {
      if (i >= n1) {
        array[k] = right[j];
        j++;
      } else if (j >= n2) {
        array[k] = left[i];
        i++;
      } else if (left[i] < right[j]) {
        array[k] = left[i];
        i++;
      } else {
        array[k] = right[j];
        j++;
      }

    }
  }
}
