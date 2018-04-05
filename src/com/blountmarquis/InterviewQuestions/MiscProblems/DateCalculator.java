package com.blountmarquis.InterviewQuestions.MiscProblems;

/**
 * Created by MLBlount on 3/18/2015.
 */
public class DateCalculator {

  public int dateToDays(String date) {

    String[] dateArr = date.split("-");
    if (dateArr.length != 3) {
      throw new DateException();
    }
    int month = Integer.parseInt(dateArr[0]);
    int day = Integer.parseInt(dateArr[1]);
    int year = Integer.parseInt(dateArr[2]);

    int monthInDays = convertMonthToDays(month, year);
    return day + monthInDays;
  }

  private int convertMonthToDays(int month, int year) {
    int monthsToCount = month - 2;
    int numOfDays = 0;
    boolean isLeapYear = Year.isLeapYear(year);
    while (monthsToCount >= 0) {
      numOfDays += Month.getDaysInMonth(monthsToCount);
      monthsToCount--;
    }
    if (isLeapYear && month > 2) {
      return numOfDays + 1;
    }
    return numOfDays;
  }

}
