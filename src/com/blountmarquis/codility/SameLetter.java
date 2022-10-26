package com.blountmarquis.codility;

import java.util.HashMap;
import java.util.Map;

public class SameLetter {

  public static int[] sameLetterPosition(String[] words) {

    Map<Character, HashMap<Integer, Integer>> letterPositions = new HashMap<>();
    int[] results = new int[]{};

    for (int wordPosition = 0; wordPosition < words.length; wordPosition++) {
      for (int letterPosition = 0; letterPosition < words[0].length(); letterPosition++) {
        Character letter = words[wordPosition].charAt(letterPosition);
        HashMap<Integer, Integer> positions = letterPositions.getOrDefault(letter, new HashMap<>());
        if (!positions.containsKey(letterPosition)) {
          positions.put(letterPosition, wordPosition);
          letterPositions.put(letter, positions);
        } else {
          results = new int[]{wordPosition, positions.get(letterPosition), letterPosition};
          break;
        }
      }
      if (results.length > 0) {
        break;
      }
    }
    return results;
  }
}
