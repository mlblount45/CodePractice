package com.blountmarquis.LeetCode;

/**
 * Created by MLBlount on 7/3/2015.
 */
public class LeetCodeNeedleInHayStack {

  public static void main(String[] args) {
    LeetCodeNeedleInHayStack obj = new LeetCodeNeedleInHayStack();

    System.out.println("start of needle location: " + obj.strStr(
        "abbabaaaabbbaabaabaabbbaaabaaaaaabbbabbaabbabaabbabaaaaababbabbaaaaabbbbaaabbaaabbbbabbbbaaabbaaaaababbaababbabaaabaabbbbbbbaabaabaabbbbababbbababbaaababbbabaabbaaabbbba",
        "bbbbbbaa"));
  }

  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (i + j == haystack.length()) {
          return -1;
        }
        if (j == needle.length()) {
          return i;
        }
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
      }
    }
  }
}
