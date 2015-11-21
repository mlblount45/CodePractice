package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by MLBlount on 11/9/2015.
 */
public class lexOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for(int i = 0; i < tests; i++){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(lexOrder(s1,s2));
        }
    }

    private static String lexOrder(String s1, String s2){
        int ptr1 = 0, ptr2 = 0;
        int n = s1.length() + s2.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(ptr1 >= s1.length()){
                sb.append(s2.charAt(ptr2++));
            }else if(ptr2 >= s2.length()){
                sb.append(s1.charAt(ptr1++));
            }else if(s1.charAt(ptr1) <= s2.charAt(ptr2)){
                sb.append(s1.charAt(ptr1++));
            }else{
                sb.append(s2.charAt(ptr2++));
            }
        } return sb.toString();

    }
}
