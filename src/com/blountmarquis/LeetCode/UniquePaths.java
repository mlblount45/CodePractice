package com.blountmarquis.LeetCode;

/**
 * Created by mlblount on 7/28/2015.
 */
public class UniquePaths {

  public static long uniquePaths(int m, int n, Long[][] memo) {
    if (m == 0 || n == 0) {
      return 1;
    }
    if (memo[m][n] == null) {
      memo[m][n] = (uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo));
    }
    return memo[m][n];
  }

  public static void main(String[] args) {
    int m = 100, n = 100;
    Long[][] memo = new Long[m][n];
    memo[0][0] = 1L;
    System.out.println("m: " + m + " n: " + n + " " + UniquePaths.uniquePaths(m - 1, n - 1, memo));
  }
}
