package com.blountmarquis.InterviewQuestions;

import java.util.HashSet;

/**
 * Created by MLBlount on 5/14/2015.
 */
public class CombinedPalindrome {

  public static boolean isCombinedPalindromeExist(String[] words) {
    if (words == null) {
      return false;
    }

    HashSet<String> set = new HashSet<String>();
    String reverse;
    for (String word : words) {
      reverse = reverseWord(word);
      if (set.contains(reverse)) {
        return true;
      } else {
        set.add(word);
      }
    }
    return false;
  }

  private static String reverseWord(String word) {
    StringBuffer sb = new StringBuffer();
    for (int i = word.length() - 1; i >= 0; i--) {
      sb.append(word.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] words = new String[]{"bat", "tabloid", "cat", "ototac", "junk"};
    if (isCombinedPalindromeExist(words)) {
      System.out.println("a combined match was found");
    } else {
      System.out.println("no match exist");
    }
  }
}
