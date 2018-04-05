package com.blountmarquis.kata;

/**
 * Created by mlblount on 1/9/2016.
 */
public class Game {

  int[] rolls = new int[21];
  int currentRoll;

  public void roll(int hits) {
    rolls[currentRoll++] = hits;
  }

  public int getScore() {
    int score = 0;
    int rollIndex = 0;
    for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
      if (isStrike(rolls[rollIndex])) {
        score += strikeBonusHit(rollIndex);
        rollIndex++;
      } else if (isSpareRolled(rollIndex)) {
        score += spareBonusHit(rollIndex);
        rollIndex += 2;
      } else {
        score += nonBonusHit(rollIndex);
        rollIndex += 2;
      }
    }
    return score;
  }

  private boolean isStrike(int roll) {
    return roll == 10;
  }

  private int strikeBonusHit(int rollIndex) {
    return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
  }

  private boolean isSpareRolled(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
  }

  private int spareBonusHit(int rollIndex) {
    return 10 + rolls[rollIndex + 2];
  }

  private int nonBonusHit(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex + 1];
  }

}
