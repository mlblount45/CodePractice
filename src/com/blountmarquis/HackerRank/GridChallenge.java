package com.blountmarquis.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mlblount on 2/17/2016.
 */
public class GridChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();

        for (int i = 0; i < test; i++) {
            int n = in.nextInt();
            in.nextLine();
            char[][] matrix = buildMatrix(in, n);
            System.out.println(isLexicographicallySorted(matrix));
        }
    }

    private static char[][] buildMatrix(Scanner in, int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        return matrix;
    }

    private static String isLexicographicallySorted(char[][] matrix) {
        int rowSize = matrix.length, colSize = matrix[0].length;
        for (int row = 0; row < rowSize; row++) {
            Arrays.sort(matrix[row]);
        }

        for (int col = 0; col < colSize; col++) {
            for (int row = 0; row < rowSize - 1; row++) {
                if (matrix[row][col] > matrix[row + 1][col]) return "NO";
            }
        }
        return "YES";
    }
}