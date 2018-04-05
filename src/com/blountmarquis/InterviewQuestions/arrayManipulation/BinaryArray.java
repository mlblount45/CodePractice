package com.blountmarquis.InterviewQuestions.arrayManipulation;

import com.blountmarquis.util.PrintableArray;

/**
 * Created by MLBlount on 4/20/2015.
 */
public class BinaryArray {

  public static void sort(int[] arr) {
    int frontPtr = 0;
    int backPtr = 0;

    while (frontPtr < arr.length) {
      if (arr[backPtr] == 1) {
        while (frontPtr < arr.length && arr[frontPtr] == 1) {
          frontPtr++;
        }
        if (frontPtr < arr.length) {
          int temp = arr[frontPtr];
          arr[frontPtr] = arr[backPtr];
          arr[backPtr] = temp;
        }
      }
      backPtr++;
    }

  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 0, 0, 1, 1, 0};
    sort(array);
    PrintableArray.printArray(array);
  }
}
