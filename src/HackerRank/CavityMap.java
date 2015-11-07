package HackerRank;

import java.util.Scanner;

/**
 * Created by MLBlount on 11/7/2015.
 */
public class CavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] matrix = buildMatrix(in, n);
        markCavities(matrix);
        printCavities(matrix);
    }

    private static int[][] buildMatrix(Scanner in, int n){
        int[][] matrix =  new int[n][n];
        for(int i = 0; i< n; i++){
            String s = in.nextLine();
            for(int j = 0; j<n; j++){
                matrix[i][j] = s.charAt(j) - '0';
            }
        }return matrix;
    }

    private static void markCavities(int[][] matrix) {
        for (int i = 1; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix.length-1; j++) {
                if(isCavity(matrix,i,j)) matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static boolean isCavity(int[][] matrix, int row, int col){
        return  matrix[row][col] > matrix[row-1][col] &&
                matrix[row][col] > matrix[row][col+1] &&
                matrix[row][col] > matrix[row+1][col] &&
                matrix[row][col] > matrix[row][col-1];
    }

    private static void printCavities(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                char c = aMatrix[j] == Integer.MAX_VALUE ? 'X' : (char) (aMatrix[j] + '0');
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
