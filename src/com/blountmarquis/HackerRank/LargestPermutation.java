package com.blountmarquis.HackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mlblount on 2/18/2016.
 */
public class LargestPermutation {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    Integer[] arr = populateArray(in, n);
    maxPerm(arr, k);
    System.out.println(PrintOrder(arr));
  }

  private static Integer[] populateArray(Scanner in, int size) {
    Integer[] arr = new Integer[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  private static void maxPerm(Integer[] arr, int k) {
    Queue<ValueLocation> q = BuildKLargestValues(arr, k);
    for (int i = k - 1; i >= 0; i--) {
      int temp = arr[i];
      arr[i] = arr[q.peek().index];
      arr[q.peek().index] = temp;
      q.poll();
    }
  }

  private static Queue<ValueLocation> BuildKLargestValues(Integer[] arr, int k) {
    Queue<ValueLocation> q = new PriorityQueue(k, new ValueLocationComparator());
    for (int i = 0; i < arr.length; i++) {
      if (q.size() < k) {
        q.offer(new ValueLocation(i, arr[i]));
        continue;
      } else if (q.peek().val < arr[i]) {
        q.poll();
        q.offer(new ValueLocation(i, arr[i]));
      }
    }
    return q;
  }

  private static String PrintOrder(Integer[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
      if (i < arr.length - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  private static class ValueLocationComparator implements Comparator<ValueLocation> {

    @Override
    public int compare(ValueLocation vl1, ValueLocation vl2) {
      return vl1.val - vl2.val;
    }
  }

  private static class ValueLocation {

    int index;
    int val;

    public ValueLocation(int i, int v) {
      index = i;
      val = v;
    }
  }
}
