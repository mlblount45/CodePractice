package com.blountmarquis.HackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mlblount on 3/3/2016.
 */
public class ValidString {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String word = in.nextLine();
    System.out.println(isWordValid(word));
  }

  private static String isWordValid(String word) {
    int[] charCount = populateCharCount(word);
    int max = getHighFrequency(charCount);
    int penaltyCount = 0;
    for (int i = 0; i < charCount.length; i++) {
      if (charCount[i] == 0 || charCount[i] == max) {
        continue;
      }
      penaltyCount++;
      if (penaltyCount == 2) {
        return "NO";
      }
    }
    return "YES";
  }

  private static int[] populateCharCount(String word) {
    int[] count = new int[26];
    for (char c : word.toCharArray()) {
      count[c - 'a']++;
    }
    return count;
  }

  private static int getHighFrequency(int[] charCount) {
    Stack<Integer> frequencies = new Stack<>();
    int lastSeen = 0;
    for (int i : charCount) {
      if (i == 0) {
        continue;
      }
      if (!frequencies.isEmpty() && i != frequencies.peek()) {
        lastSeen = frequencies.pop();
      } else {
        frequencies.push(i);
      }
    }
    return frequencies.isEmpty() ? lastSeen : frequencies.peek();
  }
}
