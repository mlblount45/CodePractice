package com.blountmarquis.HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mlblount on 3/3/2016.
 */
public class KaprekarNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();
        List<Integer> knums = getListOfKaprekarNumbers(p, q);
        if(knums.isEmpty()) System.out.println("INVALID RANGE");
        else printList(knums);
    }

    private static List<Integer> getListOfKaprekarNumbers(int p, int q) {
        List<Integer> list = new ArrayList<>();
        for (int i = p; i <= q;i++){
            if(isKaprekarNumber(i)) list.add(i);
        }
        return list;
    }

    private static boolean isKaprekarNumber(long num) {
        long val = num * num;
        LinkedList<Long> digits = populateList(val);
        int mid = digits.size()/2;
        long left = getDigitRangeSum(digits, 0, mid);
        long right = getDigitRangeSum(digits, mid, digits.size());
        return left + right == num;
    }

    private static LinkedList<Long> populateList(long val) {
        LinkedList<Long> digits = new LinkedList<>();
        while(val != 0){
            digits.addFirst(val % 10);
            val /= 10;
        }
        return digits;
    }

    private static long getDigitRangeSum(LinkedList<Long> digits, int begin, int end) {
        long sum = 0, tens = 1;
        for(int i = end - 1; i >= begin; i--){
            sum += tens * digits.get(i);
            tens *= 10;
        } return sum;
    }

    private static void printList(List<Integer> knums) {
        for (int i = 0; i < knums.size();i++) {
            System.out.print(knums.get(i) + (i < knums.size() ? " " : ""));
        }
    }
}
