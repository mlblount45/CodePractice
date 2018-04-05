package com.blountmarquis.datastructures;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeMockTest {

  BinaryTree tree = mock(BinaryTree.class);

  @Before
  public void setUp() {
    when(tree.getHeight()).thenReturn(27);
  }

  @Test
  public void getHeightTest() {
    assertSame(tree.getHeight(), 27);
  }

}
