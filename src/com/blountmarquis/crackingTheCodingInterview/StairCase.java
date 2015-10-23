package com.blountmarquis.crackingTheCodingInterview;

/**
 * Created by MLBlount on 10/9/2015.
 */
public class StairCase {
    public int getPossibleStepCombination(int n) {
        Integer[] memo = new Integer[n+1];
        return getNumOfStepCombos(n, memo);
    }

    private int getNumOfStepCombos(int n, Integer[] memo) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo[n] != null) return memo[n];
        memo[n] = getNumOfStepCombos(n - 1, memo) + getNumOfStepCombos(n - 2, memo) + getNumOfStepCombos(n-3,memo);
        return memo[n];
    }
}
