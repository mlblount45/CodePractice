package com.blountmarquis.InterviewQuestions.MiscProblems;

/**
 * Created by MLBlount on 3/18/2015.
 */
public class Month {

  private static final int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public static int getDaysInMonth(int month) {
    if (month < 0 || month > 11) {
      throw new DateException();
    }
    return months[month];
  }
}
