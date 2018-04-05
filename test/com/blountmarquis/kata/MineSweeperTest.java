package com.blountmarquis.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MLBlount on 1/17/2016.
 */
public class MineSweeperTest {

  private MineSweeper sweeper;

  @Before
  public void setUp() throws Exception {
    sweeper = new MineSweeper();
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenNullBoardThenReturnThrowIllegalArgumentException() {
    char[][] sweptMatrix = sweeper.getSweptMatrix(null);
    char[][] expectedMatrix = new char[][]{};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenEmptyBoardThenReturnEmptyMatrix() {
    char[][] mindMatrix = new char[][]{};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  private void assertArrayEquals(char[][] expectedMatrix, char[][] sweptedMatrix) {
    for (int i = 0; i < expectedMatrix.length; i++) {
      Assert.assertArrayEquals(expectedMatrix[i], sweptedMatrix[i]);
    }
  }

  @Test
  public void whenOneElementBoardNoBombsThenReturnOneCellMatrix() {
    char[][] mindMatrix = new char[][]{{'.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'0'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombEastOfOneAdjacentElementThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.', '*'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'1', '*'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombWestOfOneAdjacentElementThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'*', '.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'*', '1'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombSouthOfOneAdjacentElementThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.'}, {'*'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'1'}, {'*'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombNorthOfOneAdjacentElementThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'*'}, {'.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'*'}, {'1'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombEastOfTwoNonBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.', '.', '*'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'0', '1', '*'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombSouthEastOfTwoNonBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.', '.'}, {'.', '*'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'1', '1'}, {'1', '*'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombNorthWestOfTwoNonBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'*', '.'}, {'.', '.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'*', '1'}, {'1', '1'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombSouthWestOfTwoNonBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.', '.'}, {'*', '.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'1', '1'}, {'*', '1'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenBombNorthEastOfTwoNonBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'.', '*'}, {'.', '.'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'1', '*'}, {'1', '1'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

  @Test
  public void whenSurroundedByBombsThenReturnSweptMatrix() {
    char[][] mindMatrix = new char[][]{{'*', '*', '*'}, {'*', '.', '*'}, {'*', '*', '*'}};
    char[][] sweptMatrix = sweeper.getSweptMatrix(mindMatrix);
    char[][] expectedMatrix = new char[][]{{'*', '*', '*'}, {'*', '8', '*'}, {'*', '*', '*'}};
    assertArrayEquals(expectedMatrix, sweptMatrix);
  }

}
