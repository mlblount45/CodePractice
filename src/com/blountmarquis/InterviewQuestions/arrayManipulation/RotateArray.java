package com.blountmarquis.InterviewQuestions.arrayManipulation;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 6/8/2015.
 */
public class RotateArray {

  public static void rotateArrayRight(int[] arr, int shift) {
    int rotate = arr.length - shift;
    reverse(arr, 0, rotate - 1);
    PrintableArray.printArray("Array after first reverse: ", arr);
    reverse(arr, rotate, arr.length - 1);
    PrintableArray.printArray("Array after second reverse: ", arr);
    reverse(arr, 0, arr.length - 1);
    PrintableArray.printArray("Array after last reverse: ", arr);
  }

  public static void rotateArrayLeft(int[] arr, int shift) {
    reverse(arr, 0, shift - 1);
    PrintableArray.printArray("Array after first reverse: ", arr);
    reverse(arr, shift, arr.length - 1);
    PrintableArray.printArray("Array after second reverse: ", arr);
    reverse(arr, 0, arr.length - 1);
    PrintableArray.printArray("Array after last reverse: ", arr);
  }

  private static void reverse(int[] arr, int left, int right) {
    while (left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    int array[] = new int[]{1, 2, 3, 4, 5, 6};
    PrintableArray.printArray("Array before reverse: ", array);
    RotateArray.rotateArrayRight(array, 4);
  }
}
