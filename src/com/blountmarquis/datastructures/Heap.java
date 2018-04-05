package com.blountmarquis.datastructures;

import java.util.Arrays;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/8/2014.
 */
public class Heap extends PrintableArray {

  public static void buildMaxHeap(int[] a) {
    for (int i = (a.length / 2); i >= 0; i--) {
      maxHeapify(a, i, a.length);
    }
  }

  public static void maxHeapify(int[] array) {
    maxHeapify(array, 0, array.length);
  }

  public static void maxHeapify(int[] array, int index, int heapSize) {
    if (array == null) {
      return;
    }
    int left = (2 * index) + 1;
    int right = (2 * index) + 2;
    int largest = index;

    if (left < heapSize && array[left] > array[index]) {
      largest = left;
    }
    if (right < heapSize && array[right] > array[largest]) {
      largest = right;
    }
    if (largest != index) {
      int temp = array[index];
      array[index] = array[largest];
      array[largest] = temp;
      maxHeapify(array, largest, heapSize);
    }
  }

  public static void buildMaxHeapIterative(int[] array) {
    for (int i = array.length / 2; i >= 0; i--) {
      maxHeapifyIterative(array);
    }
  }

  public static void maxHeapifyIterative(int[] array) {
    maxHeapifyIterative(array, array.length);
  }

  protected static void maxHeapifyIterative(int[] array, int heapSize) {
    int i = 0;

    while (i < heapSize) {
      int largest = i;
      int left = (2 * i) + 1;
      int right = left + 1;

      if (left < heapSize && array[left] > array[i]) {
        largest = left;
      }
      if (right < heapSize && array[right] > array[largest]) {
        largest = right;
      }
      if (i != largest) {
        int temp = array[largest];
        array[largest] = array[i];
        array[i] = temp;
      }
      i++;
    }
  }

  public static void buildMinHeap(int[] a) {
    for (int i = (a.length / 2); i >= 0; i--) {
      minHeapify(a, i, a.length);
    }
  }

  public static void minHeapify(int[] array) {
    minHeapify(array, 0, array.length);
  }

  public static void minHeapify(int[] array, int i, int heapSize) {
    if (array == null) {
      return;
    }
    int left = (2 * i) + 1;
    int right = (2 * i) + 2;
    int smallest = i;

    if (left < heapSize && array[left] < array[i]) {
      smallest = left;
    }
    if (right < heapSize && array[right] < array[smallest]) {
      smallest = right;
    }

    if (smallest != i) {
      int temp = array[i];
      array[i] = array[smallest];
      array[smallest] = temp;
      minHeapify(array, smallest, heapSize);
    }
  }

  public static int[] maxHeapDelete(int[] array, int index) {
    if (array == null) {
      return null;
    }
    if (array.length < index || index < 0) {
      return null;
    }

    int[] copy = removeDeletedValueFromHeap(array, index);
    maxHeapify(copy, 0, copy.length);
    return copy;
  }

  public static int[] minHeapDelete(int[] array, int index) {
    if (array == null) {
      return null;
    }
    if (array.length < index || index < 0) {
      return null;
    }

    int[] copy = removeDeletedValueFromHeap(array, index);
    minHeapify(copy, 0, copy.length);
    return copy;
  }

  private static int[] removeDeletedValueFromHeap(int[] array, int index) {
    int temp = array[array.length - 1];
    array[array.length - 1] = array[index];
    array[index] = temp;
    return Arrays.copyOf(array, array.length - 1);
  }
}
