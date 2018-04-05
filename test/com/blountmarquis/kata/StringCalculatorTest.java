package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by MLBlount on 12/29/2015.
 */
public class StringCalculatorTest {

  @Test
  public void whenInputStringEmptyThenReturnZero() {
    assertEquals(0, StringCalculator.sum(""));
  }

  @Test
  public void whenInputStingIsSingleIntegerThenReturnInteger() {
    assertEquals(1, StringCalculator.sum("1"));
  }

  @Test
  public void whenInputStringIsOnePlusOneReturnTwo() {
    assertEquals(2, StringCalculator.sum("1,1"));
  }

  @Test
  public void whenInputStringIsOnePlusTwoReturnThree() {
    assertEquals(3, StringCalculator.sum("1,2"));
  }

  @Test
  public void whenInputStringIsOnePlusOnePlusOneThenReturnThree() {
    assertEquals(3, StringCalculator.sum("1,1,1"));
  }

  @Test
  public void whenInputStringContainNewLineDelimiterAndOnePlusOneReturnTwo() {
    assertEquals(2, StringCalculator.sum("1\n1"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenInputStringContainsMultipleDelimitersAndOnePlusOneNumberThenThrowInvalidFormatException() {
    assertEquals(2, StringCalculator.sum("1\n"));
  }

  @Test
  public void whenInputStringContainsUserSpecifiedDelimitersAndOnePlusOneThenReturnTwo() {
    assertEquals(2, StringCalculator.sum("//;\n1;1"));
  }
}
