package com.blountmarquis.HackerRank.Search;

import java.util.Scanner;

/**
 * Created by mlblount on 3/13/2016.
 *
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 *
 * In this problem we were challenge to find the largest cluster of 1's in a 2D array. In my implementation I applied
 * a DFS search. This algorithm individually checks boundary conditions before recurring. A more elegant approach would
 * be to check the boundary conditions at the start of the method i.e as a base conditions. Mark the current element
 * as visited as we currently are doing. Then call a single return afterwards and provide the appropriate row and col
 * values
 */
public class ConnectedCellInAGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix =  buildIntegerMatrix(in, n, m);
        System.out.println(getLargestRegionSize(matrix));
        in.close();
    }

    private static int[][] buildIntegerMatrix(Scanner in, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private static int getLargestRegionSize(int[][] matrix) {
        int max = 0;
        boolean isRegionExist = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    max = Math.max(max, getLargestRegionSize(matrix, i, j));
                    isRegionExist = true;
                }
            }
        }
        return isRegionExist ? max+1 : max;

    }

    private static int getLargestRegionSize(int[][] matrix, int row, int col) {
        matrix[row][col] = 0;
        int ret = 0;
        if(row > 0 && matrix[row-1][col] == 1)
            ret += getLargestRegionSize(matrix, row-1,col) + 1;
        if(row < matrix.length-1 && matrix[row+1][col] == 1)
            ret += getLargestRegionSize(matrix, row+1,col) + 1;
        if(col > 0 && matrix[row][col-1] == 1)
            ret += getLargestRegionSize(matrix, row,col-1) + 1;
        if(col < matrix[0].length-1 && matrix[row][col+1] == 1)
            ret += getLargestRegionSize(matrix, row,col+1) + 1;

        if(row > 0 && col > 0 && matrix[row-1][col-1] == 1)
            ret += getLargestRegionSize(matrix, row-1,col-1) + 1;
        if(row > 0 && col < matrix[0].length-1 && matrix[row-1][col+1] == 1)
            ret += getLargestRegionSize(matrix, row-1,col+1) + 1;
        if(row < matrix.length-1 && col < matrix[0].length-1 && matrix[row+1][col+1] == 1)
            ret += getLargestRegionSize(matrix, row+1,col+1) + 1;
        if(row < matrix.length-1 && col >0 && matrix[row+1][col-1] == 1)
            ret += getLargestRegionSize(matrix, row+1,col-1) + 1;
        return ret;
    }
}
