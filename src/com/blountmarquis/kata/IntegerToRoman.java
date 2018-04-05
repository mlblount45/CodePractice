package com.blountmarquis.kata;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MLBlount on 12/24/2015.
 */
public class IntegerToRoman {

  private final static Map<Integer, String> conversionMap = new LinkedHashMap<Integer, String>() {{
    put(1000, "M");
    put(900, "CM");
    put(500, "D");
    put(400, "CD");
    put(100, "C");
    put(90, "XC");
    put(50, "L");
    put(40, "XL");
    put(10, "X");
    put(9, "IX");
    put(5, "V");
    put(4, "IV");
    put(1, "I");
  }};

  public static String intToRoman(int num) {
    if (num <= 0) {
      return "";
    }
    Map.Entry<Integer, String> entry = getConversion(num);
    return entry.getValue() + intToRoman(num - entry.getKey());
  }

  private static Map.Entry<Integer, String> getConversion(int val) {
    for (Map.Entry<Integer, String> i : conversionMap.entrySet()) {
      if (i.getKey() <= val) {
        return i;
      }
    }
    return new AbstractMap.SimpleEntry<>(0, "");
  }
}
