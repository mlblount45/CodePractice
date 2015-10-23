package com.blountmarquis.LeetCode;

import java.util.Arrays;

/**
 * Created by MLBlount on 7/1/2015.
 */
public class LeetCode_Candy {

    public static int candy(int[] ratings) {
        if(ratings == null) return -1;

        Arrays.sort(ratings);

        int sum = 0;
        int pieces = 1;

        for(int i = 0; i < ratings.length; i++){
            if(sum < 1 || ratings[i] == ratings[i-1]){
                sum+=pieces;
            }else{
                pieces++;
                sum+=pieces;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,2};
        System.out.println("Min Candy Count: " + candy(arr));
    }
}
