package com.blountmarquis.kata;

import java.util.Arrays;

/**
 * Created by mlblount on 1/24/2016.
 */
public class Hamming {

  public static long hamming(int n) {
    long[] hammings = generateOnesFilledArray(n);
    return generateHamming(n, hammings);
  }

  private static long[] generateOnesFilledArray(int n) {
    long[] hammings = new long[n];
    Arrays.fill(hammings, 1);
    return hammings;
  }

  private static long generateHamming(int n, long[] hammings) {
    long twoResult = 2, threeResult = 3, fiveResult = 5;
    int twoCount = 0, threeCount = 0, fiveCount = 0;
    for (int i = 1; i < n; i++) {
      hammings[i] = Math.min(twoResult, Math.min(threeResult, fiveResult));
      if (twoResult == hammings[i]) {
        twoResult = 2 * hammings[++twoCount];
      }
      if (threeResult == hammings[i]) {
        threeResult = 3 * hammings[++threeCount];
      }
      if (fiveResult == hammings[i]) {
        fiveResult = 5 * hammings[++fiveCount];
      }
    }

    return hammings[n - 1];
  }
}
