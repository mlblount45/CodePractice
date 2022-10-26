package com.blountmarquis.datastructures;


import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * Created by MLBlount on 12/19/2015.
 */
public class MaxSegmentTreeTest {

  MaxSegmentTree maxSegTree;

  @Before
  public void setUp() throws Exception {
    maxSegTree = new MaxSegmentTree(new int[]{2, 5, -4, 6, 0});
    maxSegTree.update(4, 101);
  }

  @Test
  public void whenMaxOnEndOfRangeMaxReturned() throws Exception {
    Assert.assertSame(5, maxSegTree.maxRange(0, 2));
  }

  @Test
  public void whenMaxAtStartOfRangeMaxReturned() throws Exception {
    Assert.assertSame(101, maxSegTree.maxRange(2, 4));
  }

  @Test
  public void whenRangeLengthOneReturnSingleElement() throws Exception {
    Assert.assertSame(2, maxSegTree.maxRange(0, 0));
  }


  @Test
  public void whenEntireRangeQueiedReturnMaxElementOfArray() throws Exception {
    Assert.assertSame(101, maxSegTree.maxRange(0, 4));
  }

  @Test
  public void whenMidOfArrayQueiredReturnMax() throws Exception {
    Assert.assertSame(6, maxSegTree.maxRange(1, 3));
  }

  @Test
  public void whenEndOfArrayQueiredReturnMax() throws Exception {
    Assert.assertSame(101, maxSegTree.maxRange(3, 4));
  }

  @Test
  public void whenStartOfArrayQueiredReturnMax() throws Exception {
    Assert.assertSame(5, maxSegTree.maxRange(0, 1));
  }

  @Test
  public void whenUpdateFirstElementToMaxThenReturnAddedMax() throws Exception {
    maxSegTree.update(0, 100);
    Assert.assertSame(100, maxSegTree.maxRange(0, 1));
  }

  @Test
  public void whenUpdateLastElementToMaxThenReturnAddedMax() throws Exception {
    maxSegTree.update(4, 101);
    Assert.assertSame(101, maxSegTree.maxRange(0, 4));
  }

  @Test
  public void whenUpdateNoneMaxThenReturnMax() throws Exception {
    maxSegTree.update(2, 1);
    Assert.assertSame(101, maxSegTree.maxRange(0, 4));
  }

}