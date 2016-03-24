package com.blountmarquis.HackerRank.Implementation;

import java.util.Scanner;

/**
 * Created by mlblount on 3/23/2016.
 */
public class LarrysArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr =  buildArray(in, n);
            System.out.println(isSortable(arr));
        }
    }

    private static int[] buildArray(Scanner in, int size) {
        in.nextLine();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    private static String isSortable(int[] arr) {
        boolean isSortable = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                isSortable ^= arr[i] > arr[j];
            }
        }return isSortable  ? "YES" : "NO";
    }
}
