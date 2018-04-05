package com.blountmarquis.HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mlblount on 3/3/2016.
 */
public class TimeInWords {

  private static Map<Integer, String> hoursLookup = new HashMap<Integer, String>() {{
    put(1, "one");
    put(2, "two");
    put(3, "three");
    put(4, "four");
    put(5, "five");
    put(6, "six");
    put(7, "seven");
    put(8, "eight");
    put(9, "nine");
    put(10, "ten");
    put(11, "eleven");
    put(12, "twelve");
  }};

  private static Map<Integer, String> onesLookup = new HashMap<Integer, String>() {{
    put(1, "one");
    put(2, "two");
    put(3, "three");
    put(4, "four");
    put(5, "five");
    put(6, "six");
    put(7, "seven");
    put(8, "eight");
    put(9, "nine");
  }};

  private static Map<Integer, String> teensLookup = new HashMap<Integer, String>() {{
    put(10, "ten");
    put(11, "eleven");
    put(12, "twelve");
    put(13, "thirteen");
    put(14, "fourteen");
    put(15, "fifteen");
    put(16, "sixteen");
    put(17, "seventeen");
    put(18, "eighteen");
    put(19, "nineteen");
  }};

  private static Map<Integer, String> tensLookup = new HashMap<Integer, String>() {{
    put(2, "twenty");
    put(3, "thirty");
    put(4, "forty");
    put(5, "fifty");
  }};

  private static Map<Integer, String> specialLookup = new HashMap<Integer, String>() {{
    put(0, "o' clock");
    put(15, "quarter");
    put(30, "half");
    put(45, "quarter");
  }};

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int m = in.nextInt();
    System.out.println(getTime(h, m));
  }

  private static String getTime(int hour, int min) {
    if (min == 0) {
      return hoursLookup.get(hour) + " " + specialLookup.get(min);
    }
    if (min == 15 || min == 30) {
      return specialLookup.get(min) + " past " + hoursLookup.get(hour);
    }
    if (min == 45) {
      return specialLookup.get(min) + " to " + (hour == 12 ? hoursLookup.get(1)
          : hoursLookup.get(hour + 1));
    }

    if (min < 30) {
      String minInWords = intToWords(min);
      return minInWords + (min == 1 ? " minute " : " minutes ") + "past " + hoursLookup.get(hour);
    } else {
      String minInWords = intToWords(60 - min);
      return minInWords + (min == 1 ? " minute " : " minutes ") + "to " + (hour == 12 ? hoursLookup
          .get(1) : hoursLookup.get(hour + 1));
    }

  }

  private static String intToWords(int min) {
    if (onesLookup.containsKey(min)) {
      return onesLookup.get(min);
    } else if (teensLookup.containsKey(min)) {
      return teensLookup.get(min);
    } else if (tensLookup.containsKey(min)) {
      return tensLookup.get(min);
    } else {
      return tensLookup.get(min / 10) + " " + onesLookup.get(min % 10);
    }
  }
}
