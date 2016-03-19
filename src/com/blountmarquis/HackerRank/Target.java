package com.blountmarquis.HackerRank;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by MLBlount on 11/24/2015.
 */
public class Target {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        int N = in.nextInt();
        long R[] = new long[K];

        TreeMap<Long, Long> map = new TreeMap<Long, Long>();
        for(int R_i=0; R_i < K; R_i++){
            R[R_i] = in.nextLong();
            map.put((long)Math.pow(R[R_i],2), (long)R_i);
        }


        long x[][] = new long[N][2];
        for(int x_i=0; x_i < N; x_i++){
            for(int x_j=0; x_j < 2; x_j++){
                x[x_i][x_j] = in.nextLong();
            }
        }

        //long sum = getSum(x, map);
        long sum = getSum(x, R);
        System.out.println(sum);
    }

    private static long getSum(long[][] matrix, long[] radii) {
        long sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            sum+=getRadiusScore(matrix, i, radii);
        }return sum;
    }

    private static long getRadiusScore(long[][] matrix, int row, long[] radii) {
        long val = (long)(Math.pow(matrix[row][0],2)) + (long)(Math.pow(matrix[row][1],2));
        for(int i = radii.length; i >= 1; i--) {
            if(val <= (radii[i-1] * radii[i-1])) return i;
        } return 0;
    }

    /*private static long getSum(long[][] x, TreeMap<Long, Long> map) {
        long sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum+=getRadiusScore(x, i, map);
        }return sum;
    }*/

    /*private static long getRadiusScore(long[][] matrix, int row, TreeMap<Long, Long> map){
        long val = (long)(Math.pow(matrix[row][0],2)) + (long)(Math.pow(matrix[row][1],2));

        //System.out.println("firstKey: "+ map.firstKey());
        //System.out.println("valKey: " + map.get(val));
        if(val < map.firstKey()) return map.get(map.firstKey()) + 1L;
            //else if(map.lastKey() == val) return 1;
        else if(map.containsKey(val)) return map.get(map.lowerKey(val));
        else {
            //System.out.println("val: " + val);
            //System.out.println("lastKey: " + map.lastKey());
            if(map.lastKey() < val) return 0L;
            map.put(val, 0L);
            //System.out.println("lowerKey: " + map.lowerKey(val));
            long temp = map.get(map.lowerKey(val));
            map.remove(val);
            return temp;
        }
    }*/
}
