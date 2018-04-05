package com.blountmarquis.LeetCode;

import java.util.Arrays;

/**
 * Created by MLBlount on 12/7/2015.
 */
public class PrimeCounter {

  public static void main(String[] args) {
    PrimeCounter pc = new PrimeCounter();
    int numberOfPrimes = pc.countPrimes(5);
    System.out.println(numberOfPrimes);
  }

  /**
   * Counts the number of prime numbers less than a non-negative number, n.
   *
   * @param n The Value finding numbers of primes up to.
   * @return numbers of primes less than n; return 0 if n less than 2.
   */
  public int countPrimes(int n) {
    if (n < 2) {
      return 0;
    }
    boolean[] primeSieve = setUpSievePrime(n);
    int primeCount = 0;
    for (boolean b : primeSieve) {
      if (b) {
        primeCount++;
      }
    }
    return primeCount;
  }

  /**
   * Assume every integer greater than or equal to 2 is prime.
   * Start at the beginning of the list, if the number is prime, cross out every multiple of that number off the list. They are not prime.
   * Go to the next number, if it is crossed out, skip it - it is not prime. If it is not crossed out, it must be prime, cross out it's multiples.
   * Repeat
   */
  private boolean[] setUpSievePrime(int n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, true);
    primes[0] = primes[1] = false;
    for (int i = 2; i < n; i++) {
      if (primes[i]) {
        for (int j = 2; j * i < n; j++) {
          primes[i * j] = false;
        }
      }
    }
    return primes;
  }
}
