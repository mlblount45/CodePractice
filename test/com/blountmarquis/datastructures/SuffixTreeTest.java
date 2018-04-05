package com.blountmarquis.datastructures;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by mlblount on 3/6/2016.
 */
public class SuffixTreeTest {

  @Test
  public void whenSuffixOccursMultipleTimesInWord() throws Exception {
    assertSuffixIndices("mississippi", "is", new ArrayList<Integer>() {{
      add(1);
      add(4);
    }});
  }

  @Test
  public void whenSuffixOccursSingleTimeInWord() {
    assertSuffixIndices("mississippi", "sip", new ArrayList<Integer>() {{
      add(6);
    }});
  }

  @Test
  public void whenSuffixesOverlapInWord() {
    assertSuffixIndices("banana", "ana", new ArrayList<Integer>() {{
      add(1);
      add(3);
    }});
  }

  private void assertSuffixIndices(String testString, String suffix, List<Integer> list) {
    SuffixTree suffixTree = new SuffixTree(testString);
    assertEquals(list, suffixTree.getIndexes(suffix));
  }
}