package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by MLBlount on 12/29/2015.
 */
public class StringCalculatorKataTest {

  @Test
  public void whenStringIsEmptyReturnZero() {
    assertEquals(0, StringCalculatorKata.sum(""));
  }

  @Test
  public void whenSingleIntegerIsOneThenReturnOne() {
    assertEquals(1, StringCalculatorKata.sum("1"));
  }

  @Test
  public void whenSingleIntegerIsTwoThenReturnOne() {
    assertEquals(2, StringCalculatorKata.sum("2"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void whenNullInInputStringThenThrowIllegalArgumentException() {
    assertEquals(1, StringCalculatorKata.sum(null));
  }

  @Test
  public void whenInputIsOneCommaOneThenReturnTwo() {
    assertEquals(2, StringCalculatorKata.sum("1,1"));
  }

  @Test
  public void whenInputIsOneNewLineOneThenReturnTwo() {
    assertEquals(2, StringCalculatorKata.sum("1\n1"));
  }

  @Test
  public void whenInputIsOneNewLineOneCommaTwoThenReturnTwo() {
    assertEquals(4, StringCalculatorKata.sum("1\n1,2"));
  }

  @Test
  public void whenInputIsOneCustomDelimeterTwoThenReturnThree() {
    assertEquals(3, StringCalculatorKata.sum("//;\n1;2"));
  }
}
