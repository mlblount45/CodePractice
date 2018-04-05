package com.blountmarquis.HackerRank;


import java.util.HashMap;
import java.util.Scanner;

public class isNumberPresent {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    HashMap<Integer, Locations> lookup = buildHashLookup(arr);
    System.out.println(beforeBitFlags(lookup, arr));
    System.out.println(afterBitFlags(lookup, arr));
  }

  private static HashMap<Integer, Locations> buildHashLookup(int[] arr) {
    HashMap<Integer, Locations> map = new HashMap<Integer, Locations>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], new Locations(map.get(arr[i]).first, i));
      } else {
        map.put(arr[i], new Locations(i, i));
      }
    }
    return map;
  }

  private static String beforeBitFlags(HashMap<Integer, Locations> lookup, int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (lookup.get(val).first < i) {
        sb.append(1);
      } else {
        sb.append(0);
      }
    }
    return sb.toString();
  }

  private static String afterBitFlags(HashMap<Integer, Locations> lookup, int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (lookup.get(val).last > i) {
        sb.append(1);
      } else {
        sb.append(0);
      }
    }
    return sb.toString();
  }


  private static class Locations {

    int first;
    int last;

    Locations(int first, int last) {
      this.first = first;
      this.last = last;
    }
  }
}
