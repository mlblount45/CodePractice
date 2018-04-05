package com.blountmarquis.HackerRank.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mlblount on 3/4/2016.
 */
public class BoilerPlates {

  public static char[][] buildCharMatrix(Scanner in, int n, int m) {
    char[][] matrix = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = in.nextLine();
      for (int j = 0; j < m; j++) {
        matrix[i][j] = s.charAt(j);
      }
    }
    return matrix;
  }

  public static void printCharMatrix(char[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        sb.append(matrix[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static void printIntegerMatrix(int[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        sb.append(matrix[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static int[][] buildIntegerMatrix(Scanner in, int row, int col) {
    int[][] matrix = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        matrix[i][j] = in.nextInt();
      }
    }
    return matrix;
  }

  public static int[] buildArray(Scanner in, int size) {
    in.nextLine();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  public static String printArray(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
      if (i < arr.length - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
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