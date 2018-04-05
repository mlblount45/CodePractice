package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 *
 * Created by MLBlount on 11/7/2015.
 */
public class FunnyString {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();
    in.nextLine();
    for (int i = 0; i < tests; i++) {
      String s = in.nextLine().trim();
      System.out.println(isFunny(s));
    }
  }

  private static String isFunny(String s) {
    int n = s.length();
    for (int i = 1; i < n; i++) {
      int val1 = s.charAt(i) - s.charAt(i - 1);
      int val2 = s.charAt(n - i) - s.charAt(n - i - 1);
      if (Math.abs(val1) != Math.abs(val2)) {
        return "Not Funny";
      }
    }
    return "Funny";
  }
}
