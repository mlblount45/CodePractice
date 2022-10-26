package com.blountmarquis.datastructures;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * Created by MLBlount on 3/17/2016.
 */
public class SumSegmentTreeTest {

  SumSegmentTree sumSegmentTree;

  @Before
  public void setUp() throws Exception {
    sumSegmentTree = new SumSegmentTree(new int[]{2, 5, -4, 6, 0});
    sumSegmentTree.update(4, -5);
  }

  @Test
  public void whenBeginningRangesQueried() {
    assertSumSegmentRange(3, 0, 2);
  }

  @Test
  public void whenRangeLengthOne() {
    assertSumSegmentRange(2, 0, 0);
  }

  @Test
  public void whenEntireRangeQueriedThenReturnTotal() {
    assertSumSegmentRange(4, 0, 4);
  }

  @Test
  public void whenMidRangeQueried() {
    assertSumSegmentRange(7, 1, 3);
  }

  @Test
  public void whenEndOfRangeQueried() {
    assertSumSegmentRange(1, 3, 4);
  }

  @Test
  public void whenTreeUpdated() {
    sumSegmentTree.update(4, 100);
    assertSumSegmentRange(106, 3, 4);
  }

  private void assertSumSegmentRange(int sum, int start, int end) {
    assertEquals(sum, sumSegmentTree.sumRange(start, end));
  }
}