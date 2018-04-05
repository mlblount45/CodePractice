package com.blountmarquis.LeetCode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by MLBlount on 4/22/2015.
 */
public class Solution1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter First Number: ");
    int N = in.nextInt();
    int[][] arr1 = new int[N][N];

    System.out.print("Enter list of values: ");

    for (int j = 0; j < arr1.length; j++) {
      for (int i = 0; i < arr1.length; i++) {
        arr1[j][i] = in.nextInt();
      }
    }

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        if (j % N == 0) {
          System.out.println();
        }
        System.out.print(arr1[i][j] + " ");
      }
    }
    System.out.print("Enter allowed spaces: ");

    int allowedSpaces = in.nextInt();

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    System.out.println();

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        if (map.containsKey(arr1[i][j])) {
          if (map.get(arr1[i][j]) - 1 == 0) {
            System.out.println("YES");
            return;
          }
          map.put(arr1[i][j], map.get(arr1[i][j]) - 1);

        } else {
          map.put(arr1[i][j], allowedSpaces);
        }
      }
    }

    System.out.println("NO");


  }

   /* public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int firstNumber = in.nextInt();

        int[] arr = new int[firstNumber];
        System.out.print("Enter list of values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        for(int i: arr){
            System.out.print(i + ", ");
        }

        final String fiileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fiileName));
        bw.write("TEST!");
        bw.newLine();
        bw.close();
    }*/

}
