package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * HackerRank - Perfect Skyline
 *
 * Created by MLBlount on 12/6/2015.
 */
public class PerfectSkyline {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int H[] = new int[n];
        for (int H_i = 0; H_i < n; H_i++) {
            H[H_i] = in.nextInt();
        }
        System.out.println(isPerfectSkyline(H));
    }

    private static String isPerfectSkyline(int[] h) {
        int i = 0, j = h.length - 1;
        while(i < j){
            if(h[i] >= h[i+1]) return "Not perfect";
            if(h[i] != h[j]) return "Not perfect";
            i++; j--;
        }
        return "Perfect";
    }
}
