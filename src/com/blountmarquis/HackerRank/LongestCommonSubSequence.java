package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/12/2016.
 */
public class LongestCommonSubSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arrA = buildArray(in, n);
        int[] arrB = buildArray(in, m);
        int[][] matrix = buildLongestCommonSequenceMatrix(arrA, arrB);
        //System.out.println("Max size: " + matrix[matrix.length - 1][matrix[0].length - 1]);
        //BoilerPlates.printIntegerMatrix(matrix);
        System.out.println(printLongestCommonSequence(matrix, arrA));

    }

    public static int[] buildArray(Scanner in, int size) {
        in.nextLine();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    private static int[][] buildLongestCommonSequenceMatrix(int[] arrA, int[] arrB) {
        int rSize = arrA.length + 1;
        int cSize = arrB.length + 1;
        int[][] matrix = new int[rSize][cSize];
        for (int i = 0; i < rSize; i++) matrix[i][0] = 0;
        for (int i = 0; i < cSize; i++) matrix[0][i] = 0;

        for (int row = 1; row < rSize; row++) {
            for (int col = 1; col < cSize; col++) {
                if (arrA[row - 1] == arrB[col - 1]) matrix[row][col] = matrix[row - 1][col - 1] + 1;
                else matrix[row][col] = Math.max(matrix[row - 1][col], matrix[row][col - 1]);
            }
        }
        return matrix;
    }

    private static String printLongestCommonSequence(int[][] matrix, int[] arrA) {
        StringBuilder sb = new StringBuilder();
        for (int i = matrix.length - 1, j = matrix[0].length - 1; i > 0 && j > 0; ) {
            if (matrix[i][j] == matrix[i][j - 1]) j--;
            else if (matrix[i][j] == matrix[i - 1][j]) i--;
            else {
                sb.insert(0, arrA[i - 1] + " ");
                i--;j--;
            }
        }
        return sb.toString();
    }
}
