package com.blountmarquis.HackerRank.Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by MLBlount on 3/16/2016.
 *
 * https://www.hackerrank.com/challenges/similarpair
 *
 * I strongly dislike that this problem is attempting to test tree skills but the way the data is provided it strongly
 * begs to be put into more of a graph type data structure which also decreases development needed
 */
public class SimiliarPair {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int t = in.nextInt();

    HashMap<Integer, List<Integer>> treeMap = buildTreeMap(in, n);
    System.out.println(getNumberOfSimiliarPairs(treeMap, t));


  }

  private static HashMap<Integer, List<Integer>> buildTreeMap(Scanner in, int n) {

    HashMap<Integer, List<Integer>> map = new HashMap<>(n);
    for (int i = 0; i < n - 1; i++) {
      int key = in.nextInt();
      int setValue = in.nextInt();
      if (map.containsKey(key)) {
        map.get(key).add(setValue);
      } else {
        map.put(key, new ArrayList<Integer>());
        map.get(key).add(setValue);
      }
    }
    return map;

  }

  private static long getNumberOfSimiliarPairs(HashMap<Integer, List<Integer>> treeMap, int t) {
    long count = 0;
    Queue<List<Integer>> descendants = new LinkedList<>();
    for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
      int key = entry.getKey();
      descendants.add(entry.getValue());
      while (!descendants.isEmpty()) {
        List<Integer> temp = descendants.poll();
        for (Integer child : temp) {
          if (Math.abs(key - child) <= t) {
            count++;
          }
          if (treeMap.containsKey(child)) {
            descendants.add(treeMap.get(child));
          }
        }
      }
    }
    return count;
  }
}
