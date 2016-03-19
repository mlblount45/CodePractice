package com.blountmarquis.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by MLBlount on 11/18/2015.
 */
public class ClosestNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int minDistance = getMinDistance(arr);
        printMinDistanceElements(arr, minDistance);
    }

    private static int getMinDistance(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            min = arr[i] - arr[i-1] < min ? arr[i] - arr[i-1] : min;
        }return min;
    }

    private static void printMinDistanceElements(int[] arr, int min){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] == min) System.out.print(arr[i-1] + " " + arr[i] + " ");
        }
    }
}
