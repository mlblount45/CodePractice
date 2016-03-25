package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/5/2016.
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(longestCommonSequence(s1, s2));

    }

    private static int longestCommonSequence(String s1, String s2) {

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        longestCommonSequence(memo, s1.toCharArray(), s2.toCharArray());
        return memo[s1.length()][s2.length()];
    }

    private static void longestCommonSequence(int[][] memo, char[] s1, char[] s2) {
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1] == s2[j-1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
    }
}
