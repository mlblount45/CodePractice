package com.blountmarquis.HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mlblount on 3/9/2016.
 */
public class JavaList {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    List<Integer> list = buildList(in, n);
    int q = in.nextInt();
    for (int i = 0; i < 2 * q; i++) {
      manipulateList(in, list);
    }
    System.out.println(printList(list));
  }

  private static void manipulateList(Scanner in, List<Integer> list) {
    String operation = in.nextLine().trim();
    switch (operation) {
      case "Insert": {
        list.add(in.nextInt(), in.nextInt());
        break;
      }
      case "Delete": {
        list.remove(in.nextInt());
      }
    }
  }

  public static List<Integer> buildList(Scanner in, int size) {
    in.nextLine();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      list.add(in.nextInt());
    }
    return list;
  }


  public static String printList(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i < list.size() - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}
