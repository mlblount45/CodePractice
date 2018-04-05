package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * HackerRank - Super Highways
 * Created by MLBlount on 12/6/2015.
 */
@Deprecated //Not getting 100% marks
public class SuperHighways {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int a0 = 0; a0 < T; a0++) {
      long N = in.nextLong();
      long K = in.nextLong();
      long C = in.nextLong();
      System.out.println(highwayConnectionCost(N, K, C));
    }
  }

  private static long highwayConnectionCost(long n, long k, long c) {
    long[] baseSumArray = getBaseSumArray(n, k, c);
    long[] sumArray = getSumArray(baseSumArray);
    int size = baseSumArray.length;
    long sum = sumArray[size];
    for (int i = size - 1; i >= 0; i--) {
      sum += getSliceSum(sumArray, 1, i);
    }
    return sum;
  }

  private static long[] getBaseSumArray(long n, long k, long c) {
    long[] arr = new long[(int) n];
    for (int i = 1; i < n; i++) {
      arr[i] = i * k + c;
    }
    return arr;
  }

  private static long[] getSumArray(long[] baseSumArray) {
    long[] arr = new long[baseSumArray.length + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = arr[i - 1] + baseSumArray[i - 1];
    }
    return arr;
  }

  private static long getSliceSum(long[] sumArray, int start, int end) {
    return sumArray[end] - sumArray[start];
  }
}
