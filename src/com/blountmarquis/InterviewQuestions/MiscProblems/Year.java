package com.blountmarquis.InterviewQuestions.MiscProblems;

/**
 * Created by MLBlount on 3/18/2015.
 */
public class Year {

  public static boolean isLeapYear(int year) {
    if (year % 4 != 0) {
      return false;
    }
    if (year % 100 != 0) {
      return false;
    }
    if (year % 400 != 0) {
      return false;
    }
    return true;
  }
}
