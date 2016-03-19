package com.blountmarquis.algorithms.recursion;

/**
 * Created by MLBlount on 11/17/2015.
 */
public class NextPermutation {

    public static String getNextPermutation(String s) {
        char[] arr = s.toCharArray();
        int i = s.length() - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if(i <= 0) return "no answer";
        int j = s.length() - 1;
        while(j >= i && arr[i-1] >= arr[j]) j--;
        swap(arr, i-1,j);
        reverse(arr, i, s.length() - 1);
        return new String(arr);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int i, int j) {
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(getNextPermutation("ab"));
        System.out.println(getNextPermutation("bb"));
        System.out.println(getNextPermutation("hefg"));
        System.out.println(getNextPermutation("dhck"));
        System.out.println(getNextPermutation("dkhc"));
    }
}
