package com.blountmarquis.HackerRank.Sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by MLBlount on 3/18/2016.
 */
public class SherlockAndPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            long[] arr = buildArray(in, n);
            System.out.println(getNumberOfMatchingCombinationIndices(arr));
        }

    }
    public static long[] buildArray(Scanner in, int size) {
        in.nextLine();
        long[] arr = new long[size];
        for(int i = 0; i < size; i++) {
            arr[i] = in.nextLong();
        }
        return arr;
    }

    private static long getNumberOfMatchingCombinationIndices(long[] arr) {
        HashMap<Long, Long> matchingPairs = buildMatchMap(arr);
        long sum = 0;
        for (Map.Entry<Long,Long> entry: matchingPairs.entrySet()) {
            Long val = entry.getValue();
            if(val>1)sum+=val*(val-1);
        }return sum;
    }

    private static HashMap<Long, Long> buildMatchMap(long[] arr) {
        HashMap<Long, Long> map = new HashMap<>();
        for (long val : arr) {
            if(!map.containsKey(val)) map.put(val, 0L);
            map.put(val, map.get(val) + 1L);
        }return map;
    }
}
