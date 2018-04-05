package com.blountmarquis.HackerRank.Strings;

import java.util.Scanner;

/**
 * Created by MLBlount on 3/14/2016.
 *
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/forum
 */
@Deprecated
public class ReverseShuffleMergeLexo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    System.out.println(getSpecialWord(s));


  }

  private static String getSpecialWord(String s) {
    int[] charCount = getCharCount(s);
    return getSpecialWord(s.toCharArray(), charCount);
  }

  private static int[] getCharCount(String s) {
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    return count;
  }

  private static String getSpecialWord(char[] s,
      int[] reqCount) { //reqCount has 2x more than needed of each char
    //TODO implement
    StringBuilder sb = new StringBuilder();
    int[] seenCharCount = new int[26];
    for (int i = s.length - 1; i >= 0; i--) {
      seenCharCount[s[i]]++;
      if (charIsNeededBasedOnOccurrenceReq(reqCount, seenCharCount, s[i])) {
        sb.insert(0, s[i]);
      } else if (isCharSmallest(s, reqCount, seenCharCount)) {

      }
    }
    return null;
  }

  private static boolean isCharSmallest(char[] s, int[] reqCount, int[] seenCharCount) {
    //TODO implement
    return false;

  }


  private static boolean charIsNeededBasedOnOccurrenceReq(int[] reqCount, int[] seenCharCount,
      char s) {
    return seenCharCount[s - 'a'] * 2 > reqCount[s - 'a'];
  }

}
