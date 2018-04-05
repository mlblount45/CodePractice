package com.blountmarquis.algorithms.recursion;

/**
 * Created by mlblount on 2/21/2016.
 */
public class GaussSum {

  public static void main(String[] args) {
    System.out.println(gaussSum(100));
  }

  private static int gaussSum(int num) {
    return gaussSum(num, 0, 0);
  }

  private static int gaussSum(int num, int curr, int sum) {
    if (curr > num) {
      return sum;
    }
    return gaussSum(num, curr + 1, sum + curr);
  }

}
