package com.blountmarquis.LeetCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by MLBlount on 2/6/2016.
 */
public class FindSubStringTest {

  @Test
  public void whenStringAndWordsIsEmptyThenReturnEmptyList() {
    assertEquals(new ArrayList<>(), FindSubString.findSubstring("", new String[0]));
  }

  @Test
  public void whenStringContainsOneInstanceOfWord() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(0);
    }};
    String s = "cat";
    String[] words = new String[]{"cat"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenStringContainsTwoInstancesOfWord() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(0);
      add(3);
    }};
    String s = "catcat";
    String[] words = new String[]{"cat"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenDisturbanceBetweenWords() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(0);
      add(4);
    }};
    String s = "catdcat";
    String[] words = new String[]{"cat"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenDoesntContainWord() {
    List<Integer> list = new ArrayList<Integer>();
    String s = "catdcat";
    String[] words = new String[]{"cats"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenContainsMultipleWordsWithMatches() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(0);
    }};
    String s = "catdog";
    String[] words = new String[]{"cat", "dog"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenContainsMultipleWordsWithMatchesAndDisturbance() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(3);
    }};
    String s = "catcatdog";
    String[] words = new String[]{"cat", "dog"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenContainsMultipleWordsWithNoMatches() {
    List<Integer> list = new ArrayList<Integer>();
    String s = "catscartdog";
    String[] words = new String[]{"cat", "dog"};
    assertSubStringLocations(list, s, words);
  }

  @Test
  public void whenContainsMultipleWordsWithOffSetMatches() {
    List<Integer> list = new ArrayList<Integer>() {{
      add(1);
    }};
    String s = "ccatdog";
    String[] words = new String[]{"cat", "dog"};
    assertSubStringLocations(list, s, words);
  }

  private void assertSubStringLocations(List<Integer> list, String s, String[] words) {
    assertEquals(list, FindSubString.findSubstring(s, words));
  }
}