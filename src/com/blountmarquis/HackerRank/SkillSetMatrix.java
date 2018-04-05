package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team
 *
 * Created by MLBlount on 11/7/2015.
 *
 * This solution only works with M <= 32 as I used ints to hold a given persons skill set which is incorrect.
 * To fix this i.e. make it usable for larger inputs a multideminsional array is needed instead of an array of int's
 */
@Deprecated
public class SkillSetMatrix {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    in.nextLine();
    int[] skillMatrix = new int[n];
    for (int i = 0; i < n; i++) {
      skillMatrix[i] = Integer.parseInt(in.nextLine().trim(), 2);
    }
    int[] maxCountPair = getMaxCountPair(skillMatrix);
    for (int i : maxCountPair) {
      System.out.println(i);
    }
  }

  private static int[] getMaxCountPair(int[] skillMatrix) {
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < skillMatrix.length; i++) {
      for (int j = i + 1; j < skillMatrix.length; j++) {
        int res = getOnesCount(skillMatrix[i] | skillMatrix[j]);
        if (res > max) {
          max = res;
          count = 1;
        } else if (res == max) {
          count++;
        }
      }
    }
    return new int[]{max, count};
  }

  private static int getOnesCount(int val) {
    int count = 0;
    while (val != 0) {
      if ((val & 1) == 1) {
        count++;
      }
      val >>= 1;
    }
    return count;
  }
}
