package com.blountmarquis.InterviewQuestions.StringManipulation;

/**
 * Created by mlblount on 6/11/2015.
 */
public class StringReverser {
    public static String reverseString(String s){
        if(s == null) return null;

        char[] cArr = s.toCharArray();
        reverse(cArr, 0, cArr.length - 1);
        return new String(cArr);
    }

    private static void reverse(char[] cArr, int start, int end) {
        if(start >= end) return;

        swap(cArr, start,end);
        reverse(cArr,++start,--end);
    }

    private static void swap(char[] cArr, int start, int end) {
        char temp = cArr[start];
        cArr[start] = cArr[end];
        cArr[end] = temp;
    }

    public static void main(String[] args){
        System.out.println(reverseString("Hello World"));
    }
}
