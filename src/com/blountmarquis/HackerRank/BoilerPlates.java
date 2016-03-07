package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/4/2016.
 */
public class BoilerPlates {

    public static int[][] buildIntegerMatrix(Scanner in, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private static int[][] buildCharMatrix(Scanner in, int n){
        int[][] matrix =  new int[n][n];
        for(int i = 0; i< n; i++){
            String s = in.nextLine();
            for(int j = 0; j<n; j++){
                matrix[i][j] = s.charAt(j) - '0';
            }
        }return matrix;
    }

    public static void printIntegerMatrix(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printCharMatrix(char[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int[] buildArray(Scanner in, int size) {
        in.nextLine();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static String printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
            if(i < arr.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}