package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by MLBlount on 11/22/2015.
 *
 * HackerRank Competition week of code 18
 * difficulty level = 18
 */
public class Ghost {


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int A = in.nextInt();
    int B = in.nextInt();
    int C = in.nextInt();
    int D = in.nextInt();

    System.out.print(getNumberOfGhost(A, B, C, D));
  }

  private static int getNumberOfGhost(int a, int b, int c, int d) {
    int count = 0;

    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= b; j++) {
        for (int k = 1; k <= c; k++) {
          for (int l = 1; l <= d; l++) {
            if (isCaseOneValid(i, j) &&
                isCaseTwoValid(j, k) &&
                isCaseThreeValid(i, k) &&
                isCaseFourValid(i, l)) {
              count++;
            }
          }
        }
      }
    }

    return count;
  }

  private static boolean isCaseOneValid(int a, int b) {
    return (a - b) % 3 == 0;
  }

  private static boolean isCaseTwoValid(int b, int c) {
    return (b + c) % 5 == 0;
  }

  private static boolean isCaseThreeValid(int a, int c) {
    return (a * c) % 4 == 0;
  }

  private static boolean isCaseFourValid(int a, int d) {
    return gcd(a, d) == 1;
  }

  private static int gcd(int a, int d) {
    return d == 0 ? a : gcd(d, a % d);
  }


}
