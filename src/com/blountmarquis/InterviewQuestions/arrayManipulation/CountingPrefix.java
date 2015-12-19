package com.blountmarquis.InterviewQuestions.arrayManipulation;

/**
 * Created by MLBlount on 4/12/2015.
 */
public class CountingPrefix {
    /**
     * <p>Generate prefix sum array of <i>arr</i></p>
     * @param arr Array to generate prefix sum out of.
     * @return
     */
    public static int[] getPrefixSums(int[] arr){
        int[] sums = new int[arr.length + 1];

        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i-1] + arr[i-1];
        }
        return  sums;
    }

    /**
     * <p>Calculates slice of array from index <i>start</i> to index <i>end</i></p>
     * @param sums prefix sum array
     * @param start starting index of slice to be calculated
     * @param end ending index of slice to be calculated
     * @return sum of slice <i>sum[end + 1] - sums[start]</i>
     */
    public static int countTotalSlice(int[] sums, int start, int end){
        return sums[end + 1] - sums[start];
    }

    public static void main(String[] args) {
        int[] sums = CountingPrefix.getPrefixSums(new int[]{1, 3, 5});
        System.out.println(CountingPrefix.countTotalSlice(sums,1,2));
    }
}
