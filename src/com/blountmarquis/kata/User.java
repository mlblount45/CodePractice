package com.blountmarquis.kata;

/**
 * Created by mlblount on 1/23/2016.
 */
public class User {

  private static final int MAX_RANK = 8;
  private static final int SAME_LEVEL_POINTS = 3;
  private static final int ONE_LEVEL_LOWER_POINTS = 1;
  private static final int POINT_ACCELERATE_CONSTANT = 10;
  private static final int PROGRESS_POINT_TARGET = 100;
  private static final int DEFAULT_PROGRESS = 0;
  private static final int DEFAULT_RANK = -8;
  //private RankingSystem system = new RankingSystem();
  private int progress;
  private int rank;

  public User(int rank) {
    this.rank = rank;
  }

  public User() {
    this.rank = DEFAULT_RANK;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public void incProgress(int rankCompleted) {
    if (rankCompleted == 0 || rankCompleted < -8 || rankCompleted > 8) {
      throw new IllegalArgumentException();
    }
    this.progress = calculateProgress(rank, progress, rankCompleted);
    this.rank = ifEnoughPointsEarnedCycleProgressRankUp(rank, progress);
    if (this.progress >= 100) {
      this.progress %= PROGRESS_POINT_TARGET;
    }
    if (this.rank == MAX_RANK) {
      this.progress = 0;
    }
  }

  private int calculateProgress(int rank, int progress, int rankCompleted) {
    if (rank == MAX_RANK) {
      return 0;
    }
    if (isExceriseAndRankSameLevel(rankCompleted)) {
      progress += SAME_LEVEL_POINTS;
    } else if (isExceriseOneLevelLowerThanRank(rankCompleted, rank)) {
      progress += ONE_LEVEL_LOWER_POINTS;
    } else if (isExcerciseLevelGreaterThanRank(rankCompleted)) {
      int difference = Math.abs(rank - rankCompleted);
      if (isPolarityChanged(rank, rankCompleted)) {
        difference--;
      }
      progress += POINT_ACCELERATE_CONSTANT * (difference * difference);
    }
    return progress;
  }

  private boolean isExceriseAndRankSameLevel(int rankCompleted) {
    return rankCompleted == rank;
  }

  private boolean isExceriseOneLevelLowerThanRank(int rankCompleted, int rank) {
    if (isPolarityChanged(rankCompleted, rank)) {
      rankCompleted++;
    }
    return rankCompleted + 1 == rank;
  }

  private boolean isExcerciseLevelGreaterThanRank(int rankCompleted) {
    return rankCompleted > rank;
  }

  private int ifEnoughPointsEarnedCycleProgressRankUp(int rank, int progress) {
    if (progress >= PROGRESS_POINT_TARGET) {
      int cycles = progress / PROGRESS_POINT_TARGET;
      int temp = rank;
      rank += cycles;
      if (isPolarityChanged(temp, rank)) {
        rank++;
      }
      if (rank >= MAX_RANK) {
        rank = MAX_RANK;
      }
    }
    return rank;
  }

  private boolean isPolarityChanged(int prevRank, int newRank) {
    return prevRank < 0 && newRank >= 0;
  }

  public int getRank() {
    return rank;
  }

}
