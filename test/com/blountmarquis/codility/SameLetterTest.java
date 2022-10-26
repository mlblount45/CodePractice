package com.blountmarquis.codility;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SameLetterTest {

  @Test
  public void whenHappyPath() {
    String[] words = new String[]{"abc", "bca", "dbe"};
    int[] actuals = SameLetter.sameLetterPosition(words);
    System.out.println(actuals[0] + " " + actuals[1] + " " + actuals[2]);
    int[] expected = new int[]{2, 0, 1};
    assertArrayEquals(expected, actuals);
  }

  @Test
  public void whenHappyPath1() {
    String[] words = new String[]{"zzzz", "ferz", "zdsr", "fgtd"};
    int[] actuals = SameLetter.sameLetterPosition(words);
    System.out.println(actuals[0] + " " + actuals[1] + " " + actuals[2]);
    int[] expected = new int[]{1, 0, 3};
    assertArrayEquals(expected, actuals);
  }

  @Test
  public void whenHappyPath2() {
    String[] words = new String[]{"gr", "sd", "rg"};
    int[] actuals = SameLetter.sameLetterPosition(words);
    int[] expected = new int[]{};
    assertArrayEquals(expected, actuals);
  }

  @Test
  public void whenHappyPath3() {
    String[] words = new String[]{"bdafg", "ceagi"};
    int[] actuals = SameLetter.sameLetterPosition(words);
    System.out.println(actuals[0] + " " + actuals[1] + " " + actuals[2]);
    int[] expected = new int[]{1, 0, 2};
    assertArrayEquals(expected, actuals);
  }
}