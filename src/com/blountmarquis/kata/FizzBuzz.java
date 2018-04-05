package com.blountmarquis.kata;

/**
 * Created by MLBlount on 12/22/2015.
 */
public class FizzBuzz {

  public static String getFizzBuzzResponse(int num) {
    if (num == 0) {
      return num + "";
    }
    if (isMultipleOfThree(num) && isMultipleOfFive(num) == 0) {
      return "FizzBuzz";
    }
    if (isMultipleOfThree(num)) {
      return "Fizz";
    }
    if (isMultipleOfFive(num) == 0) {
      return "Buzz";
    }
    return num + "";
  }

  private static int isMultipleOfFive(int num) {
    return num % 5;
  }

  private static boolean isMultipleOfThree(int num) {
    return num % 3 == 0;
  }
}
