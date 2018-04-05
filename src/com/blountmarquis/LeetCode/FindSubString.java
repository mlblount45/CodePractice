package com.blountmarquis.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MLBlount on 2/6/2016.
 */
public class FindSubString {

  public static List<Integer> findSubstring(String s, String[] words) {
    if (words.length < 1) {
      return new ArrayList();
    }

    int start, wordLength = words[0].length();
    int sliceLength = wordLength * words.length;

    Map<String, Integer> wordsLookup = buildLookup(words);
    List<Integer> startLoc = new ArrayList<Integer>();
    for (start = 0; start + sliceLength - 1 < s.length(); start++) {
      String sub = s.substring(start, start + sliceLength);
      if (isSubString(sub, wordsLookup, wordLength)) {
        startLoc.add(start);
      }
    }

    return startLoc;
  }

  private static Map<String, Integer> buildLookup(String[] words) {
    Map<String, Integer> lookup = new HashMap<String, Integer>();
    for (String s : words) {
      if (lookup.containsKey(s)) {
        lookup.put(s, lookup.get(s) + 1);
      } else {
        lookup.put(s, 1);
      }
    }
    return lookup;
  }

  private static boolean isSubString(String sub, Map<String, Integer> wordLookup, int wordLength) {
    Map<String, Integer> subLookup = new HashMap<String, Integer>();

    for (int i = 0; i < sub.length(); i += wordLength) {
      String s = sub.substring(i, i + wordLength);
      if (!wordLookup.containsKey(s)) {
        return false;
      } else if (subLookup.containsKey(s)) {
        if (subLookup.get(s) == wordLookup.get(s)) {
          return false;
        }
        subLookup.put(s, subLookup.get(s) + 1);
      } else {
        subLookup.put(s, 1);
      }
    }
    return true;
  }
}
