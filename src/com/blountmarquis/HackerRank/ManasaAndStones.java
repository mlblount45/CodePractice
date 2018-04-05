package com.blountmarquis.HackerRank;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mlblount on 3/3/2016.
 */
public class ManasaAndStones {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      possibleLastVal(n, a, b);
      System.out.println();
    }
  }

  private static void possibleLastVal(int n, int a, int b) {
    Set<Integer> list = new TreeSet<>();
    possibleLastVal(list, n - 1, a, b, 0);
    printList(list);
  }

  private static void possibleLastVal(Set<Integer> nums, int n, int a, int b, int curr) {
    if (n == 0) {
      nums.add(curr);
      return;
    }
    possibleLastVal(nums, n - 1, a, b, curr + a);
    possibleLastVal(nums, n - 1, a, b, curr + b);
  }

  private static void printList(Set<Integer> nums) {
    StringBuilder sb = new StringBuilder();
    for (int i : nums) {
      sb.append(i + " ");
    }
    System.out.print(sb);
  }


}