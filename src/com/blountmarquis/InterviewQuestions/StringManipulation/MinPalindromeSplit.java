package com.blountmarquis.InterviewQuestions.StringManipulation;

/**
 * Created by MLBlount on 6/9/2015.
 */
public class MinPalindromeSplit {

  public static int getMinPalindromeSplit(String s) {
    if (isPalindrome(s) || s.isEmpty()) {
      return 0;
    }
    return 1 + Math.min(getMinPalindromeSplit(s.substring(1)),
        getMinPalindromeSplit(s.substring(0, s.length() - 1)));
  }

  private static boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("Min Split: " + getMinPalindromeSplit("cocBOB"));
  }
}
