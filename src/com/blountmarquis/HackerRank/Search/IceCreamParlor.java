package com.blountmarquis.HackerRank.Search;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mlblount on 3/12/2016.
 *
 * https://www.hackerrank.com/challenges/icecream-parlor
 *
 * Full Marks however it was extremely wasteful to use an array then convert to a HashMap
 * Should have took the input and put it directly into the hashmap storing it identically
 * as below. key = M - val, val = index.
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = buildArray(in, n);
            printIndexPair(arr, m);
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

    private static void printIndexPair(int[] arr, int m) {
        int x = 0, y=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                x = map.get(arr[i]) +1;
                y= i +1;
                break;
            }
            map.put(m - arr[i],i);
        }
        System.out.println(x + " " + y);
    }
}
