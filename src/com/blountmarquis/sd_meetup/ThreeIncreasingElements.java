package com.blountmarquis.sd_meetup;

/**
 * Created by MLBlount on 8/2/2015.
 */
public class ThreeIncreasingElements {

    public static ThreeIndices getIncreasingElements(int[] arr) {
        if (arr == null || arr.length < 3) return null;

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n - 1; j++) {
                if (arr[i] < arr[j]) {
                    for (int k = j+1; k < n; k++) {
                        if(arr[j] < arr[k]) return new ThreeIndices(i,j,k);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(ThreeIncreasingElements.getIncreasingElements(new int[]{1,2,3}));
    }

    private static class ThreeIndices {
        int i;
        int j;
        int k;

        public ThreeIndices(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public String toString() {
            return "ThreeIndices{" +
                    "i=" + i +
                    ", j=" + j +
                    ", k=" + k +
                    '}';
        }
    }
}
