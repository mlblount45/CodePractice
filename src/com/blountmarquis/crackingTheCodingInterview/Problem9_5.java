package com.blountmarquis.crackingTheCodingInterview;

import java.util.ArrayList;

/**
 * Created by MLBlount on 5/13/2015.
 */
public class Problem9_5 {

  public static ArrayList<String> getPerm(String s) {
    ArrayList<String> perms = new ArrayList<String>();
    getPerm("", s, perms);
    return perms;
  }

  private static void getPerm(String seen, String unSeen, ArrayList<String> perms) {

    if (unSeen.length() == 0) {
      perms.add(seen);
    } else {
      for (int i = 0; i < unSeen.length(); i++) {
        String next = seen + unSeen.charAt(i);
        String remaining = unSeen.substring(0, i) + unSeen.substring(i + 1);
        getPerm(next, remaining, perms);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<String> perms = getPerm("A");
    for (String p : perms) {
      System.out.print(p + " ");
    }
  }

}
