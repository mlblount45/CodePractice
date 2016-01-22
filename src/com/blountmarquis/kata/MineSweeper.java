package com.blountmarquis.kata;

/**
 * Created by MLBlount on 1/17/2016.
 */
public class MineSweeper {

    public static final char BOMB_SYMBOL = '*';

    public char[][] getSweptMatrix(char[][] matrix) {
        if (matrix == null) throw new IllegalArgumentException();
        buildSweepMatrix(matrix);
        return matrix;
    }

    private void buildSweepMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != BOMB_SYMBOL) {
                    matrix[row][col] = bombCountToChar(matrix, row, col);
                }
            }
        }
    }

    private char bombCountToChar(char[][] matrix, int row, int col) {
        return (char) (countAdjacentBombs(matrix, row, col) + '0');
    }

    private int countAdjacentBombs(char[][] matrix, int row, int col) {
        int count = 0;
        count += isCellABomb(matrix, row - 1, col) ? 1 : 0;
        count += isCellABomb(matrix, row - 1, col + 1) ? 1 : 0;
        count += isCellABomb(matrix, row, col + 1) ? 1 : 0;
        count += isCellABomb(matrix, row + 1, col + 1) ? 1 : 0;
        count += isCellABomb(matrix, row + 1, col) ? 1 : 0;
        count += isCellABomb(matrix, row + 1, col - 1) ? 1 : 0;
        count += isCellABomb(matrix, row, col - 1) ? 1 : 0;
        count += isCellABomb(matrix, row - 1, col - 1) ? 1 : 0;
        return count;
    }

    private boolean isCellABomb(char[][] matrix, int row, int col) {
        if (!inRange(matrix, row, col)) return false;
        return matrix[row][col] == BOMB_SYMBOL;
    }

    private boolean inRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
