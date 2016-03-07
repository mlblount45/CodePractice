package com.blountmarquis.HackerRank;

import java.util.Scanner;

/**
 * Created by mlblount on 3/5/2016.
 *
 * This solution is correct but is time inefficient
 */
public class LexicographicStringMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(lexicographicallyMerge(s1+"Z", s2+"Z"));
        }
    }

    private static String lexicographicallyMerge(String s1, String s2) {
        SuffixArray sa1 = new SuffixArray(s1);
        SuffixArray sa2 = new SuffixArray(s2);

        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        while (i < sa1.length-1 || j < sa2.length-1){
            if(i >= sa1.length) {sb.append(sa2.select(j));break;}
            else if (j >= sa2.length) {sb.append(sa1.select(i));break;}
            else if (sa1.suffices[i].compareTo(sa2.suffices[j]) < 1) sb.append(sa1.suffices[i++].charAt(0));
            else if (sa1.suffices[i].compareTo(sa2.suffices[j]) >= 1) sb.append(sa2.suffices[j++].charAt(0));
        }
        return sb.toString();
    }

    private static class SuffixArray {
        final Suffix[] suffices;
        public final int length;
        public SuffixArray(String text) {
            length = text.length();
            suffices = new Suffix[length];
            for(int i = 0; i < length; i++) {
                suffices[i] = new Suffix(text, i);
            }
        }

        private class Suffix implements Comparable<Suffix>{
            String text;
            int index;

            public Suffix(String text, int i) {
                this.text = text;
                this.index = i;
            }

            public char charAt(int i){
                return text.charAt(index + i);
            }

            public int length(){
                return text.length() - index;
            }

            public String toString(){
                return text.substring(index);
            }

            @Override
            public int compareTo(Suffix that) {
                int n = Math.min(this.length(), that.length());
                for(int i = 0; i < n; i++) {
                    if(this.charAt(i) < that.charAt(i)) return -1;
                    if(this.charAt(i) > that.charAt(i)) return 1;
                }return this.length() - that.length();
            }
        }

        public String select(int i){
            return suffices[i].toString();
        }
    }
}
