package com.blountmarquis.HackerRank.Search;

import java.util.Scanner;

/**
 * Created by mlblount on 3/12/2016.
 * <p/>
 * https://www.hackerrank.com/challenges/count-luck
 * <p/>
 * In this problem we are tasked with finding the total number of decision paths when attempting to find our way from
 * cell marked as 'M' in the matrix to cell marked as '*' in the matrix (in this order). When then must compare the
 * total number of decisions needed with the predicted number of decisions 'K'.
 * <p/>
 * This solution implements a DFS search when visiting a cell we mark the current cell as visited then visit all of
 * the neighboring cells which are valid locations to visit. Each cell is also evaluated to determine how many possible
 * paths this cell has if 0 pop this recursive call from the recursive stack else if 1 add zero to next recursive
 * call else add 1 to the next recursive call.
 */
public class CountLuck {
    static Location[] locations = new Location[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] matrix = buildCharMatrixAndSetLocations(in, n, m);
            int k = in.nextInt();
            int directionChanges = numberOfDirectionChanges(matrix, locations[0].row, locations[0].col);
            System.out.println(k == directionChanges ? "Impressed" : "Oops!");
        }
    }

    public static char[][] buildCharMatrixAndSetLocations(Scanner in, int n, int m) {
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                matrix[i][j] = c;
                if (c == 'M') locations[0] = new Location(i, j);
                if (c == '*') locations[1] = new Location(i, j);
            }
        }
        return matrix;
    }

    private static int numberOfDirectionChanges(char[][] matrix, int row, int col) {
        int res = 0;
        if (row == locations[1].row && col == locations[1].col) return 0;
        matrix[row][col] = 'X';
        int paths = numberOfPaths(matrix, row, col);
        if (paths == 0) return -1;
        if (paths > 1) res = 1;


        if (row > 0 && matrix[row-1][col] != 'X') {
            int result = numberOfDirectionChanges(matrix, row - 1, col);
            if (result != -1) return result + res;

        } if (row < matrix.length-1 && matrix[row+1][col] != 'X') {
            int result = numberOfDirectionChanges(matrix, row + 1, col);
            if(result != -1) return result + res;
        }
        if (col > 0 && matrix[row][col-1] != 'X') {
            int result = numberOfDirectionChanges(matrix, row, col - 1);
            if(result != -1) return result + res;
        }
        if (col < matrix[0].length-1  && matrix[row][col+1] != 'X') {
            int result =  numberOfDirectionChanges(matrix, row, col + 1);
            if(result != -1) return result + res;
        }
        return -1;
    }

    private static int numberOfPaths(char[][] matrix, int row, int col) {
        int count = 0;
        if (row > 0 && matrix[row - 1][col] != 'X') count++;
        if (row < matrix.length - 1 && matrix[row + 1][col] != 'X') count++;
        if (col > 0 && matrix[row][col - 1] != 'X') count++;
        if (col < matrix[0].length - 1 && matrix[row][col + 1] != 'X') count++;
        return count;
    }

    static class Location {
        int row;
        int col;

        public Location(int i, int j) {
            row = i;
            col = j;
        }
    }
}

