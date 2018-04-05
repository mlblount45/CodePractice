package com.blountmarquis.HackerRank.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/board-cutting
 *
 * Created by mlblount on 2/20/2016.
 */
public class BoardCutting {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int test = in.nextInt();

    for (int i = 0; i < test; i++) {
      int ysize = in.nextInt();
      int xsize = in.nextInt();
      //in.nextLine();
      int[] arr1 = populateArray(in, ysize - 1);
      int[] arr2 = populateArray(in, xsize - 1);
      System.out.println(getMinCost(arr1, arr2));
    }

  }

  private static int[] populateArray(Scanner in, int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  private static int getMinCost(int[] arr1, int[] arr2) {
    int total, colCuts, rowCuts;
    total = colCuts = rowCuts = 0;
    int rowPointer = arr1.length - 1;
    int colPointer = arr2.length - 1;
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    while (rowPointer >= 0 || colPointer >= 0) {
      if (rowPointer < 0) {
        total += arr2[colPointer] * (rowCuts + 1);
        colCuts++;
        colPointer--;
      } else if (colPointer < 0) {
        total += arr1[rowPointer] * (colCuts + 1);
        rowCuts++;
        rowPointer--;
      } else if (arr1[rowPointer] > arr2[colPointer]) {
        total += arr1[rowPointer] * (colCuts + 1);
        rowCuts++;
        rowPointer--;
      } else if (arr1[rowPointer] < arr2[colPointer]) {
        total += arr2[colPointer] * (rowCuts + 1);
        colCuts++;
        colPointer--;
      } else {
        total += arr2[colPointer] * (Math.min(rowCuts, colCuts) + 1);
        if (rowCuts > colCuts) {
          rowCuts++;
          rowPointer--;
        } else {
          colCuts++;
          colPointer--;
        }
      }
    }
    return total % (1000000007);
  }
}
