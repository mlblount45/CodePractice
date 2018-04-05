package com.blountmarquis.datastructures;

import java.util.ArrayList;

/**
 * Created by MLBlount on 2/22/2015.
 */
public class ArrayListHeap {

  public static void buildHeap(ArrayList<Integer> list) {
    for (int i = (list.size() / 2); i >= 0; i--) {
      heapify(list, i, list.size());
    }
  }

  public static void heapify(ArrayList<Integer> list, int i, int size) {
    int left = (2 * i) + 1;
    int right = (2 * i) + 2;
    int largest = i;
    if (left < size && list.get(left) > list.get(largest)) {
      largest = left;
    }
    if (right < size && list.get(right) > list.get(largest)) {
      largest = right;
    }
    if (largest != i) {
      int temp = list.get(i);
      list.set(i, list.get(largest));
      list.set(largest, temp);
      heapify(list, largest, size);
    }
  }
}
