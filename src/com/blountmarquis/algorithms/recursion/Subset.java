package com.blountmarquis.algorithms.recursion;

import java.util.ArrayList;

/**
 * Created by MLBlount on 5/12/2015.
 */
public class Subset {

  public static ArrayList<String> subSetString(String str) {
    ArrayList<String> subSets = new ArrayList<String>();
    subSetString("", str, subSets);
    return subSets;

  }

  private static void subSetString(String seen, String unseen, ArrayList<String> subSets) {
    if (unseen.length() == 0) {
      subSets.add(seen);
    } else {
      subSetString(seen, unseen.substring(1), subSets);
      subSetString(seen + unseen.charAt(0), unseen.substring(1), subSets);
    }
  }

  public static void main(String[] args) {
    ArrayList<String> set = Subset.subSetString("Help");
    for (String s : set) {
      System.out.print(s + ", ");
    }
  }
}
