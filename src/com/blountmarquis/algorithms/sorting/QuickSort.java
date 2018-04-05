package com.blountmarquis.algorithms.sorting;

import java.util.Random;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/12/2014.
 */
public class QuickSort {

  /**
   * In place sort using divide and conquer approach, by partitioning the array into two subarrays then
   * sorting the two halfs independently. Once the subarrays are sorted the whole array is sorted.
   */
  public static void sort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  private static void quickSort(int[] array, int left, int right) {
    PrintableArray.printArray("Array is: ", array);
    int mid = randomPartition(array, left, right);

    if (left < mid - 1) {
      System.out.println("selected pivot is: " + array[mid]);
      quickSort(array, left, mid - 1);
    }
    if (mid < right) {
      System.out.println("selected pivot is: " + array[mid]);
      quickSort(array, mid, right);
    }
  }

  /**
   * <p>Rearrange the array so all elements smaller than the pivot value reside to the left of pivot and
   * all values greater than the pivot value reside to the right of the pivot values.</p>
   * <p>To achieve this, randomly, select the pivot value.
   * While left count is less than or equal to right count repeat the following:
   * Loop starting at the leftmost element increment left index to the next element if and only if left element is less than
   * pivot value else break loop. Loop starting at the rightmost element decrement right index to the prev element if and only if
   * right element is greater than pivot value, else break loop. If left count is less than or equal to right count
   * swap the left element greater than pivot with the right element less than pivot increment left index decrement
   * right index. Return right most left index.</p>
   *
   * <p>This partition algorithm was adopted from Cracking the Coding interview. </p>
   */
  private static int randomPartition(int[] array, int left, int right) {
    int pivotIndex = rand(left, right);
    int pivot = array[pivotIndex];
    while (left <= right) {
      while (array[left] < pivot) {
        left++;
      }
      while (array[right] > pivot) {
        right--;
      }
      if (left <= right) {
        swap(array, left, right);
        left++;
        right--;
      }
    }
    return left;
  }


  private static int rand(int min, int max) {
    Random rand = new Random();
    return rand.nextInt(max - min + 1) + min;
  }

  private static void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }


  public static void sortAlternative(int[] arr) {
    quickSortAlternative(arr, 0, arr.length - 1);
  }

  private static void quickSortAlternative(int[] arr, int left, int right) {
    if (left <= right) {
      PrintableArray.printArray("Array is", arr);
      int mid = partitionAlternative(arr, left, right);
      System.out.println("selected pivot is: " + arr[mid]);
      quickSortAlternative(arr, left, mid - 1);
      quickSortAlternative(arr, mid + 1, right);
    }
  }

  /**
   * <p>This partition Algorithm was adopted from introduction to algorithms. And The algorithm Design Manual</p>
   */
  private static int partitionAlternative(int[] arr, int start, int end) {
    int pivotIndex = rand(start, end);
    int pivot = arr[pivotIndex];
    swap(arr, end, pivotIndex);
    pivotIndex = end;
    int i = start - 1;
    for (int j = start; j <= end - 1; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, pivotIndex);
    return i + 1;
  }

  public static void main(String[] args) {
    int array[] = new int[]{99, 5, 16, 4, 10, 13, 14, 0, 7, 6, 9, 3, 2, 8,
        1}; //=> 1, 2, 3, 4, 7, 8, 9, 10, 14, 16
    QuickSort.sort(array);
    System.out.println();
    PrintableArray.printArray(array);
  }
}
