package com.blountmarquis.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by mlblount on 1/23/2016.
 */
public class UserTest {

  private User system;

  @Ignore
  public void whenUserCompletesRank2LevelsBelowThenProgressNotEffected() {
    intializePlayerCondition(-6, -8);
    assertEquals(0, system.getProgress());
  }


  @Ignore
  public void whenUserCompletesRankOneLevelBelowThenProgresPlusOneCase1() {
    intializePlayerCondition(-6, -7);
    assertEquals(1, system.getProgress());
  }

  @Ignore
  public void whenUserCompletesRankOneLevelBelowThenProgresPlusOneCase2() {
    intializePlayerCondition(6, 5);
    assertEquals(1, system.getProgress());
  }

  @Ignore
  public void whenUserCompletesRankSameLevelThenProgresPlus3() {
    intializePlayerCondition(-6, -6);
    assertEquals(3, system.getProgress());
  }

  @Ignore
  public void whenUserCompletesRankOneLevelAboveThenProgresPlus10() {
    intializePlayerCondition(-6, -5);
    assertEquals(10, system.getProgress());
  }

  @Ignore
  public void whenUserCompletesRankTwoLevelsAboveThenProgresPlus40() {
    intializePlayerCondition(6, 8);
    assertEquals(40, system.getProgress());
  }

  @Ignore
  public void whenUserObtainsEnoughProgressPointsToLevelUpProgressPointsCycle() {
    intializePlayerCondition(4, 8);
    assertEquals(60, system.getProgress());
  }

  @Ignore
  public void whenUserObtainsEnoughProgressPointsToLevelUpThenUserRankLevelsUp() {
    intializePlayerCondition(4, 8);
    assertEquals(5, system.getRank());
  }

  @Ignore
  public void whenUserObtainsEnoughProgressPointsToLevelUpTwiceThenUserRankLevelsUpTwice() {
    intializePlayerCondition(-8, -3);
    assertEquals(-6, system.getRank());
  }

  @Ignore
  public void whenUserObtainsMultipleLevelUpLevelUpMultipleTimes() {
    intializePlayerCondition(-8, 1);
    assertEquals(-2, system.getRank());
  }

  @Test
  public void whenUserObtainsMultipleLevelUpHandleProgressCycle() {
    system = new User(1);
    system.setProgress(20);
    system.incProgress(-1);
    assertEquals(21, system.getProgress());
  }

  @Ignore
  public void whenUserHasMaxRankThenProgressRemainsZero() {
    intializePlayerCondition(8, 8);
    assertEquals(0, system.getProgress());
  }

  @Ignore
  public void whenUserRanksUpFromNegativeToPositiveThenUserShouldRankSkipValueZero() {
    system = new User(-1);
    system.setProgress(99);
    system.incProgress(-2);
    assertEquals(1, system.getRank());
  }

  @Ignore
  public void whenUserRanksUpPastMaxRankUpThenProgressReturn0() {
    system = new User(7);
    system.setProgress(99);
    system.incProgress(8);
    assertEquals(0, system.getProgress());
  }


  private void intializePlayerCondition(int currentRank, int levelCompled) {
    system = new User(currentRank);
    system.incProgress(levelCompled);
  }


}
