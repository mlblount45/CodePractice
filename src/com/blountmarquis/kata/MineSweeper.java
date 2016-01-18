package com.blountmarquis.kata;

/**
 * Created by MLBlount on 1/17/2016.
 */
public class MineSweeper {
    public char[][] getSweptMatrix(char[][] matrix) {
        if(matrix == null) throw new IllegalArgumentException();
        buildSweepMatrix(matrix);
        return matrix;
    }

    private void buildSweepMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int count = checkAdjacentsForBombs(matrix, i, j);
                if (matrix[i][j] != '*') matrix[i][j] = (char) (count + '0');
            }
        }
    }

    private int checkAdjacentsForBombs(char[][] matrix, int i, int j) {
        int count = 0;
        count += checkNorthForBomb(matrix, i, j);
        count += checkNorthEastForBomb(matrix, i, j);
        count += checkEastForBomb(matrix, i, j);
        count += checkSouthEastForBomb(matrix, i, j);
        count += checkSouthForBomb(matrix, i, j);
        count += checkSouthWestForBomb(matrix, i, j);
        count += checkWestForBomb(matrix, i, j);
        count += checkNorthWestForBomb(matrix, i, j);
        return count;
    }

    private int checkNorthForBomb(char[][] matrix, int i, int j) {
        return i - 1 >= 0 && matrix[i - 1][j] == '*' ? 1 : 0;
    }

    private int checkNorthEastForBomb(char[][] matrix, int i, int j) {
        return j + 1 < matrix[0].length && i - 1 >= 0 && matrix[i - 1][j + 1] == '*' ? 1 : 0;
    }

    private int checkEastForBomb(char[][] matrix, int i, int j) {
        return j + 1 < matrix[0].length && matrix[i][j + 1] == '*' ? 1 : 0;
    }

    private int checkSouthEastForBomb(char[][] matrix, int i, int j) {
        return j + 1 < matrix[0].length && i + 1 < matrix.length && matrix[i + 1][j + 1] == '*' ? 1 : 0;
    }

    private int checkSouthForBomb(char[][] matrix, int i, int j) {
        return i + 1 < matrix.length && matrix[i + 1][j] == '*' ? 1 : 0;
    }

    private int checkSouthWestForBomb(char[][] matrix, int i, int j) {
        return j - 1 >= 0 && i + 1 < matrix.length && matrix[i + 1][j - 1] == '*' ? 1 : 0;
    }

    private int checkWestForBomb(char[][] matrix, int i, int j) {
        return j - 1 >= 0 && matrix[i][j - 1] == '*' ? 1 : 0;
    }

    private int checkNorthWestForBomb(char[][] matrix, int i, int j) {
        return j - 1 >= 0 && i - 1 >= 0 && matrix[i - 1][j - 1] == '*' ? 1 : 0;
    }
}
