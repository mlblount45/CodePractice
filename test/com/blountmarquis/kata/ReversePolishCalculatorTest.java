package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by mlblount on 1/24/2016.
 */
public class ReversePolishCalculatorTest {


  @Test
  public void whenExpressionIsEmptyThenReturnZero() {
    assertEquals(0, getEvaluation(""), 0.001);
  }

  @Test
  public void whenSingleIntegerExpressionThenReturnInteger() {
    assertEquals(1, getEvaluation("1"), 0.001);
  }

  @Test
  public void whenSingleAdditionOperationThenReturnSum() {
    assertEquals(2, getEvaluation("1 1 +"), 0.001);
  }

  @Test
  public void whenSingleSubtractionOperationThenReturnDifference() {
    assertEquals(0, getEvaluation("1 1 -"), 0.001);
  }

  @Test
  public void whenSingleMultiplicationOperationThenReturnProduct() {
    assertEquals(1, getEvaluation("1 1 *"), 0.001);
  }

  @Test
  public void whenSingleDivisionThenReturnQuotient() {
    assertEquals(1, getEvaluation("1 1 /"), 0.001);
  }


  @Test
  public void whenMultiOperation() {
    assertEquals(3, getEvaluation("1 1 * 2 +"), 0.001);
  }

  private Double getEvaluation(String s) {
    return ReversePolishCalculator.evaluate(s);
  }
}
