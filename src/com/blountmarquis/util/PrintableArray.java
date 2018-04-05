package com.blountmarquis.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by MLBlount on 10/3/2014.
 */
public class PrintableArray {

  public static void printArray(String s, int[] array) {
    System.out.print(s + ": ");
    printArray(array);
  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        System.out.print(array[i]);
      } else {
        System.out.print(", " + array[i]);
      }
    }
    System.out.println();
  }

  public static void printArrayDescendingOrder(Integer[] arr) {
    Arrays.sort(arr, new ComparatorDescending());
    printArray(arr);
  }

  public static void printArray(Integer[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        System.out.print(arr[i]);
      } else {
        System.out.print(", " + arr[i]);
      }
    }
    System.out.println();
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}

class ComparatorDescending implements Comparator {

    /*@Override
    public int compare(Integer o1,Integer o2) {
        return (Integer)o2 - (Integer)o1;
    }*/

  @Override
  public int compare(Object o1, Object o2) {
    return (Integer) o2 - (Integer) o1;
  }
}