package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/5/2016.
 */
public class RotateArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] arr = buildArray(in, n);
        /* NAIVE APPROACH COST O(N) SPACE
        int[] rotatedArray = new int[n];
        naiveRotateArray(arr, rotatedArray, k);*/
        rotateArray(arr,k);
        for (int i = 0; i < q; i++) {
            //System.out.println(rotatedArray[in.nextInt()]);
            System.out.println(arr[in.nextInt()]);
        }
    }

    /**
     * Rotate Array right in place k times
     * @param arr array to be rotated
     * @param k number of rotations
     */
    private static void rotateArray(int[] arr, int k) {
        int rotation = arr.length - (k%arr.length);
        reverse(arr,0,rotation-1);
        reverse(arr, rotation, arr.length - 1);
        reverse(arr,0,arr.length - 1);
    }

    private static void reverse(int[] arr, int i, int j) {
        for(;i < j;i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void naiveRotateArray(int[] arr, int[] rotatedArray, int k) {
        int index = k % arr.length;
        for(int i = 0; i < arr.length; i++) {
            rotatedArray[index++%arr.length] = arr[i];
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
}