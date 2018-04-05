package com.blountmarquis.algorithms.sorting;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/3/2014.
 */
public class SelectionSort extends PrintableArray {

  public static void sort(int[] array) {
    if (array == null) {
      return;
    }

    for (int i = 0; i < (array.length - 1); i++) {
      int smallest = array[i];
      for (int j = (i + 1); j < array.length; j++) {
        if (array[j] < smallest) {
          array[i] = array[j];
          array[j] = smallest;
          smallest = array[i];
        }
      }
    }
  }
}
