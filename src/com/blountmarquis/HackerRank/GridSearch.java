package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by MLBlount on 11/7/2015.
 */
public class GridSearch {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();
    for (int i = 0; i < tests; i++) {
      int[][] matrix = buildMatrix(in);
      int[][] pattern = buildMatrix(in);
      System.out.println(isPatternExist(matrix, pattern));
    }
  }

  private static int[][] buildMatrix(Scanner in) {
    int row = in.nextInt();
    int col = in.nextInt();
    int[][] matrix = new int[row][col];
    in.nextLine();

    for (int i = 0; i < row; i++) {
      String s = in.nextLine();
      for (int j = 0; j < col; j++) {
        matrix[i][j] = s.charAt(j) - '0';
      }
    }
    return matrix;
  }

  private static String isPatternExist(int[][] matrix, int[][] pattern) {
    int mStart = 0;
    int prow = 0, pcol = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = mStart; j < matrix[0].length; j++) {
        if (prow < pattern.length && pcol < pattern[0].length
            && matrix[i][j] != pattern[prow][pcol]) {
          if (mStart != 0) {
            j = 0;
            mStart = 0;
          } else if (prow != 0 || pcol != 0) {
            j--;
            //if(j < -1) System.out.println("went negative from j");
            //j = j-1 < -1? -1:0;
          }
          prow = 0;
          pcol = 0;
        } else if (prow < pattern.length && pcol < pattern[0].length
            && matrix[i][j] == pattern[prow][pcol]) {
          pcol++;
          if (pcol == pattern[0].length) {
            mStart = j - pcol + 1;
            if (mStart < 0) {
              mStart = 0;
              j = 0;
              prow = 0;
            }
            pcol = 0;
            prow++;
            if (prow == pattern.length) {
              return "YES";
            }
            break;
          }
        }
      }
    }
    return "NO";
  }
}
