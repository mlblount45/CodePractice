package com.blountmarquis.algorithms.divideandconquer;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 10/5/2014.
 */


public class MaxSubArray extends PrintableArray {

  public static int[] findMaxSubArray(int[] array) {
    if (array == null) {
      return null;
    }
    SubArrayData subArrayData;
    subArrayData = findMaxSubArray(array, 0, array.length - 1);
    System.out.println(subArrayData);
    int[] subArray = getSubArray(array, subArrayData.minIndex, subArrayData.maxIndex);
    return subArray;
  }

  private static SubArrayData findMaxSubArray(int[] array, int low, int high) {
    if (array == null) {
      return null;
    }
    if (low == high) {
      return new SubArrayData(low, high, array[low]);
    }
    int mid = (high + low) / 2;

    SubArrayData leftSubArrayData = findMaxSubArray(array, low, mid);
    SubArrayData rightSubArrayData = findMaxSubArray(array, mid + 1, high);
    SubArrayData midSubArrayData = findMaxMidCrossingSubArray(array, low, mid, high);

    if (leftSubArrayData.sum >= rightSubArrayData.sum
        && leftSubArrayData.sum >= midSubArrayData.sum) {
      return leftSubArrayData;
    } else if (rightSubArrayData.sum >= leftSubArrayData.sum
        && rightSubArrayData.sum >= midSubArrayData.sum) {
      return rightSubArrayData;
    } else {
      return midSubArrayData;
    }
  }

  private static SubArrayData findMaxMidCrossingSubArray(int[] array, int low, int mid, int high) {
    if (array == null) {
      return null;
    }
    SubArrayData data = new SubArrayData(0, 0, 0);
    int leftSum = 0;

    int sum = 0;
    for (int i = mid; i >= low; i--) {
      sum += array[i];
      if (leftSum < sum) {
        leftSum = sum;
        data.minIndex = i;
      }
    }

    sum = 0;
    int rightSum = 0;
    for (int i = mid + 1; i <= high; i++) {
      sum += array[i];
      if (rightSum < sum) {
        rightSum = sum;
        data.maxIndex = i;
      }
    }
    data.sum = leftSum + rightSum;
    return data;
  }

  public static int[] bruteForceFindMaxSubArray(int[] array) {
    if (array == null) {
      throw new NullPointerException();
    }

    int sum = 0;
    int tempSum = 0;
    int maxLeft = 0;
    int maxRight = 0;
    for (int i = 0; i < array.length; i++) {
      tempSum = tempSum + array[i];
      if (sum < tempSum) {
        sum = tempSum;
        maxLeft = i;
        maxRight = i;
      }
      for (int j = i + 1; j < array.length; j++) {
        tempSum += array[j];
        if (sum < tempSum) {
          sum = tempSum;
          maxLeft = i;
          maxRight = j;
        }
      }
      tempSum = 0;
    }
    int[] subArray = getSubArray(array, maxLeft, maxRight);
    return subArray;
  }

  private static int[] getSubArray(int[] array, int maxLeft, int maxRight) {
    int[] subArray = new int[(maxRight - maxLeft) + 1];
    int j = 0;
    int i = maxLeft;

    while (i <= maxRight) {
      subArray[j] = array[i];
      j++;
      i++;
    }
    return subArray;
  }

  private static class SubArrayData {

    int minIndex;
    int maxIndex;
    int sum;

    public SubArrayData() {
    }
    public SubArrayData(SubArrayData data) {
      this.maxIndex = data.maxIndex;
      this.minIndex = data.minIndex;
      this.sum = data.sum;
    }
    public SubArrayData(int minIndex, int maxIndex, int sum) {
      this.minIndex = maxIndex;
      this.maxIndex = maxIndex;
      this.sum = sum;
    }

    @Override
    public String toString() {
      return "SubArrayData{" +
          "minIndex=" + minIndex +
          ", maxIndex=" + maxIndex +
          ", sum=" + sum +
          '}';
    }
  }
}
