package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/4/2016.
 */
public class MatrixRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int rotations = in.nextInt();
        int[][] matrix = buildIntegerMatrix(in,row,col);
        buildRotatedMatrix(matrix, rotations);
        printIntegerMatrix(matrix);
    }

    private static void buildRotatedMatrix(int[][] matrix, int rotations) {
        int rows = matrix.length, cols = matrix[0].length;
        int layers = Math.min(rows, cols)/2;
        for(int i = 0; i < layers; i++) {
            int parameter = 2*((rows-2*i) + (cols-2*i)) - 4;
            for (int j = 0; j < rotations%parameter; j++) {
                int layerRowStart = i, layerRowEnd = rows - i -1;
                int layerColStart = i, layerColEnd = cols - i-1;
                Integer last = matrix[layerRowStart][layerColStart];
                last = moveSouth(matrix, layerRowStart+1, layerRowEnd, layerColStart,last);
                last = moveEast(matrix, layerColStart+1, layerColEnd, layerRowEnd,last);
                last = moveNorth(matrix, layerRowEnd-1, layerRowStart, layerColEnd,last);
                moveWest(matrix, layerColEnd-1, layerColStart, layerRowStart,last);
            }
        }
    }

    private static Integer moveSouth(int[][] matrix, int layerRowStart, int layerRowEnd, int layerColStart, Integer last) {
        Integer temp=null;
        for(;layerRowStart <= layerRowEnd;layerRowStart++){
            temp = matrix[layerRowStart][layerColStart];
            matrix[layerRowStart][layerColStart] = last;
            last = temp;
        }
        return temp;
    }

    private static Integer moveEast(int[][] matrix, int layerColStart, int layerColEnd, int layerRowStart, Integer last) {
        Integer temp=null;
        for(;layerColStart <= layerColEnd;layerColStart++){
            temp = matrix[layerRowStart][layerColStart];
            matrix[layerRowStart][layerColStart] = last;
            last = temp;
        }
        return temp;
    }

    private static Integer moveNorth(int[][] matrix, int layerRowStart, int layerRowEnd, int layerColStart, Integer last) {
        Integer temp=null;
        for(;layerRowStart >= layerRowEnd;layerRowStart--){
            temp = matrix[layerRowStart][layerColStart];
            matrix[layerRowStart][layerColStart] = last;
            last = temp;
        }
        return temp;
    }

    private static Integer moveWest(int[][] matrix, int layerColStart, int layerColEnd, int layerRowStart, Integer last) {
        Integer temp=null;
        for(;layerColStart >= layerColEnd;layerColStart--){
            temp = matrix[layerRowStart][layerColStart];
            matrix[layerRowStart][layerColStart] = last;
            last = temp;
        }
        return temp;
    }

    private static int[][] buildIntegerMatrix(Scanner in, int row, int col) {
        in.nextLine();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private static void printIntegerMatrix(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
