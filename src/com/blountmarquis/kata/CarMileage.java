package com.blountmarquis.kata;

import java.util.List;
import java.util.Stack;

/**
 * Created by mlblount on 1/24/2016.
 */
public class CarMileage {
    public static int isInteresting(int mileage, int[] interestingPhases) {
        int score = 0;
        for(int i = 0; i < 3; i++) {
            if (mileage + i < 100) continue;
            List<Integer> digits = getDigits(mileage+i);

            score = isFollowedByZeroScore(digits) ? 2 : score;
            score = getSameDigitScore(digits) ? 2 : score;
            score = isIncreasing(digits) ? 2 : score;
            score = isDecreasing(digits) ? 2 : score;
            score = isPalindrome(digits) ? 2 : score;
            score = isExistInPhrase(mileage+i, interestingPhases) ? 2 : score;
            if(score > 0) return i == 0 ? 2 : 1;
        }
        return 0;
    }

    private static List<Integer> getDigits(int mileage) {
        List<Integer> digits = new Stack<>();
        while (mileage > 0) {
            int temp = mileage % 10;
            digits.add(temp);
            mileage /= 10;
        }
        return digits;
    }

    private static boolean isFollowedByZeroScore(List<Integer> mileage) {
        for (int i = mileage.size() - 2; i >= 0; i--) {
            if (mileage.get(i) != 0) return false;
        }
        return true;
    }

    private static boolean getSameDigitScore(List<Integer> mileage) {
        int target = mileage.get(0);
        for (int i = 1; i < mileage.size(); i++) {
            if (mileage.get(i) != target) return false;
        }
        return true;
    }

    private static boolean isIncreasing(List<Integer> digits) {
        for(int i = digits.size() - 2; i >=0; i--) {
            if(digits.get(i) == 0 && digits.get(i+1) == 9) continue;
            if(digits.get(i) - 1 != digits.get(i+1)) return false;
        } return true;
    }

    private static boolean isDecreasing(List<Integer> digits) {
        for(int i = digits.size() - 2; i >=0; i--) {
            if(digits.get(i) + 1 != digits.get(i+1)) return false;
        } return true;
    }

    private static boolean isPalindrome(List<Integer> digits) {
        int start = 0;
        int end = digits.size()- 1;
        while(start < end){
            if(digits.get(start) != digits.get(end)) return false;
            start++;
            end--;
        }return true;
    }

    private static boolean isExistInPhrase(int mileage, int[] interestingPhases) {
        for (int i : interestingPhases)
            if (i == mileage) return true;
        return false;
    }

}
