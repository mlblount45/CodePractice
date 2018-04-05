package com.blountmarquis.kata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MLBlount on 12/29/2015.
 */

/**
 * NEED TO CLEAN UP buildTokens method
 */
public class StringCalculator {

  public static int sum(String str) {
    if (str.length() == 0) {
      return 0;
    }
    if (str.length() == 1) {
      return Integer.parseInt(str);
    }
    String[] tokens = buildToken(str);
    return getSum(tokens);
  }

  private static String[] buildToken(String str) {
    Pattern pattern = Pattern.compile("//(.)\n");
    Matcher matcher = pattern.matcher(str);
    if (matcher.find()) {
      String customDelimeter = matcher.group(1);
      String regex = "[,\n" + customDelimeter + "]";
      return str.split("//(.)\n")[1].split(regex);
    }
    return str.split("[,\n]");
  }

  private static int getSum(String[] tokens) {
    if (tokens.length < 2) {
      throw new IllegalArgumentException();
    }
    int sum = 0;
    for (String s : tokens) {
      sum += Integer.parseInt(s);
    }
    return sum;
  }
}
