package com.blountmarquis.LeetCode;

/**
 * Created by MLBlount on 7/3/2015.
 */
public class LeetCode_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length + nums2.length == 0) return 0.0;
        if(nums1.length + nums2.length == 1)
            return singleElementMedian(nums1,nums2);
        if(nums1.length + nums2.length == 2)
            return twoElementMedian(nums1,nums2);
        int i = 0, j = 0, k = 0;
        double median = 0.0;
        int mid = (nums1.length + nums2.length)/2;

        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        if(!isEven)
            mid++;
        while(k < mid){
            if(i >= nums1.length){
                median = nums2[j++];
            }else if(j >= nums2.length) {
                median = nums1[i++];
            }else if(nums1[i] <= nums2[j]){
                median = nums1[i++];
            }else{
                median = nums2[j++];
            }
            k++;
        }
        System.out.println("median is: " + median);

        if(isEven){
            int median2 = 0;
            if(i >= nums1.length){
                median2 = nums2[j++];
            }else if(j >= nums2.length) {
                median2 = nums1[i++];
            }else if(nums1[i] <= nums2[j]){
                median2 = nums1[i++];
            }else{
                median2 = nums2[j++];
            }
            System.out.println("median2 is: " + median2);
            return (median + median2)/2.0;
        }else
            return median;

    }

    private int singleElementMedian(int[] nums1, int[] nums2){
        return nums1.length == 1 ? nums1[0] : nums2[0];
    }

    private double twoElementMedian(int[] nums1, int[] nums2){
        double median = 0;
        switch(nums1.length){
            case 0:{
                median = (nums2[0] + nums2[1])/2.0;
                break;
            }
            case 1:{
                median = (nums1[0] + nums2[0])/2.0;
                break;
            }
            case 2:{
                median = (nums1[0] + nums1[1])/2.0;
                break;
            }
        }
        return median;
    }

    public static void main(String args[]){
        int[] arr1 = new int[]{1,1,2,5,6};
        int[] arr2 = new int[]{2,4,6,9,88};

        LeetCode_FindMedianSortedArrays median = new LeetCode_FindMedianSortedArrays();
        System.out.println("Median is: " + median.findMedianSortedArrays(arr1, arr2));
    }
}
