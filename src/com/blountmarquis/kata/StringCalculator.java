package com.blountmarquis.kata;

/**
 * Created by MLBlount on 12/29/2015.
 */
public class StringCalculator {
    public static int sum(String str) {
        if (str.length() == 0) return 0;
        if (str.length() == 1) return Integer.parseInt(str);
        String[] tokens = str.split("[,\n]+");
        return getSum(tokens);
    }

    private static int getSum(String[] tokens) {
        if (tokens.length < 2) throw new IllegalArgumentException();
        int sum = 0;
        for (String s : tokens) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
