package com.blountmarquis.HackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This implementation doesn't seem to work when using Kadane algorithm many solution are implemented using a Treeset.
 * Revisit how others are doing this currently doesn't make much sense to me. Below are a few references.
 * <p>
 * <a href="https://github.com/Perilynn/HackerRank-Coding-Challenges/blob/master/Search/Maximise%20Sum/Aravind.java">GitHub Java Solution</a>
 * <a href="https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem">Quora explanation</a>
 * <a href="http://stackoverflow.com/questions/31113993/maximum-subarray-sum-modulo-m">StackOverflow explanation</a>
 * </p>
 *
 * Created by MLBlount on 11/21/2015.
 */
@Deprecated
public class MaximiseSum {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();
    for (int i = 0; i < tests; i++) {
      in.nextLine();
      int n = in.nextInt() + 1;
      long mod = in.nextLong();
      in.nextLine();
      long[] arr = new long[n];
      for (int j = 1; j < n; j++) {
        arr[j] = (arr[j - 1] + in.nextLong()) % mod;
      }
      System.out.println(maxModdedSlice(arr, mod));
      Set<Integer> s = new HashSet<Integer>();
      Integer[] a = (Integer[]) s.toArray();
    }
  }

  private static long maxModdedSlice(long[] arr, long mod) {
    long maxSlice = arr[0] % mod;
    long maxEnd = arr[0] % mod;
    for (int i = 1; i < arr.length; i++) {
      maxEnd = Math.max(arr[i] % mod, (maxEnd + arr[i]) % mod);
      maxSlice = Math.max(maxEnd, maxSlice);
    }
    return maxSlice;
  }
}
