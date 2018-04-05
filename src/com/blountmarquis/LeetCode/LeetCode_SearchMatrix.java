package com.blountmarquis.LeetCode;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 7/2/2015.
 */
public class LeetCode_SearchMatrix {

  public static void main(String[] args) {
    LeetCode_SearchMatrix searchMatrix = new LeetCode_SearchMatrix();
    int[][] matrix = new int[][]{{1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};
    PrintableArray.printMatrix(matrix);
    System.out.println("Element present in matrix: " + searchMatrix.searchMatrix(matrix, 10));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    return rowBinarySearch(matrix, 0, matrix.length - 1, target);
  }

  private boolean rowBinarySearch(int[][] matrix, int start, int end, int target) {
    if (start > end) {
      return false;
    }

    int mid = (start + end) / 2;
    System.out.println("Row at: " + mid);
    if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) {
      return colBinarySearch(matrix, mid, 0, matrix[0].length - 1, target);
    } else if (matrix[mid][0] > target) {
      System.out.println("Row going down");
      return rowBinarySearch(matrix, start, mid - 1, target);

    } else {
      System.out.println("Row going up");
      return rowBinarySearch(matrix, mid + 1, end, target);
    }
  }

  private boolean colBinarySearch(int[][] matrix, int row, int start, int end, int target) {
    if (start > end) {
      return false;
    }
    int mid = (start + end) / 2;

    System.out.println("Col at: " + mid);
    if (matrix[row][mid] == target) {
      return true;
    } else if (matrix[row][mid] < target) {
      System.out.println("Col going right");
      return colBinarySearch(matrix, row, mid + 1, end, target);
    } else {
      System.out.println("Col going left");
      return colBinarySearch(matrix, row, start, mid - 1, target);
    }
  }
}
