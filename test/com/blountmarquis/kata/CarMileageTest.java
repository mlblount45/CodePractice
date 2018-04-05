package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by mlblount on 1/24/2016.
 */
public class CarMileageTest {

  @Test
  public void whenMileageLessThan99Return0() {
    assertEquals(0, getMileageInterestingScoreNoPhraseArray(1));
  }

  @Test
  public void whenMillageFollowedByAllZerosReturn2() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(100));
  }

  @Test
  public void whenNotFollowedByAllZerosReturn0() {
    assertEquals(0, getMileageInterestingScoreNoPhraseArray(103));
  }

  @Test
  public void whenAllNumbersSameThenReturn2() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(111));
  }

  @Test
  public void whenDigitsIncresingThenReturn2() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(1234));
  }

  @Test
  public void whenDigitsIncreasingZeroShouldComeAfterNine() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(7890));
  }

  @Test
  public void whenDigitsAreDecreasingThenReturn2() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(4321));
  }

  @Test
  public void whenDigitsAreDecreasingZeroShouldComeAfterOne() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(3210));
  }


  @Test
  public void whenDigitsArePalindromeReturn2() {
    assertEquals(2, getMileageInterestingScoreNoPhraseArray(1331));
  }

  @Test
  public void whenMileageEqualPhraseArrayElementThenReturn2() {
    assertEquals(2, CarMileage.isInteresting(1292, new int[]{1292}));
  }


  @Test
  public void whenAllNumbersCloseToSameThenReturn1() {
    assertEquals(1, getMileageInterestingScoreNoPhraseArray(109));
  }

  @Test
  public void whenMillageCloseToHavingFollowedByAllZerosReturn1() {
    assertEquals(1, getMileageInterestingScoreNoPhraseArray(99));
  }

  @Test
  public void whenMillageCloseToPalindromeReturn1() {
    assertEquals(1, getMileageInterestingScoreNoPhraseArray(1879));
  }

  private int getMileageInterestingScoreNoPhraseArray(int mileage) {
    return CarMileage.isInteresting(mileage, new int[0]);
  }
}
