package com.blountmarquis.pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MLBlount on 9/5/2015.
 */
public class QuadSum {

  private static int[] getQuadSumN2(int[] arr, int sum) {
    int n = arr.length;
    Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int pairTwoSum = arr[i] + arr[j];
        if (map.containsKey(pairTwoSum)) {
          Pair p = getNonDuplicatePair(i, j, map, pairTwoSum);
          if (p != null) {
            return new int[]{p.val1, p.val2, i, j};
          }
        } else {
          List<Pair> pList = new ArrayList<Pair>();
          pList.add(new Pair(i, j));
          map.put(sum - pairTwoSum, pList);
        }
      }
    }
    return null;
  }

  private static Pair getNonDuplicatePair(int i, int j, Map<Integer, List<Pair>> map, int sum) {
    for (Pair p : map.get(sum)) {
      if (p.val1 != i && p.val1 != j & p.val2 != i && p.val2 != j) {
        return p;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    //                      0 1  2   3  4  5  6  7  8
    int[] array = new int[]{1, 8, 4, 24, 3, 4, 5, 7, 10}; // returns indices: 0, 8, 1, 4
    //int[] array = new int[]{10, 1, 10 ,1};                 // returns indices: 0, 2, 1, 3
    //int[] array = new int[]{10, 1, 1 ,1};               // returns indices: "no quad sum exist"
    int[] quadSumIndices = getQuadSumN2(array, 22);
    if (quadSumIndices == null) {
      System.out.println("no quad sum exist");
    } else {
      for (int i : quadSumIndices) {
        System.out.print(i + ", ");
      }
    }
  }

  public static class Pair {

    int val1;
    int val2;

    public Pair(int a, int b) {
      val1 = a;
      val2 = b;
    }
  }

}

