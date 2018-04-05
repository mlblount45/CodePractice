package com.blountmarquis.InterviewQuestions.arrayManipulation;

import java.util.Stack;

/**
 * Created by MLBlount on 4/11/2015.
 */
public class Leader {

  /**
   * <p>The leader of a sequence is the element whose
   * value occurs more than n/2 times. The sequence can have at most one leader
   * </p>
   *
   * @param arr The array to find the leader out of returns null if a <i>Leader</i> does not exist.
   * @return The <i>Leader value</i>
   */
  public static Integer getLeader(int[] arr) {
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (stack.isEmpty()) {
        stack.push(arr[i]);
      } else {
        if (arr[i] != stack.peek()) {
          stack.pop();
        } else {
          stack.push(arr[i]);
        }
      }

    }
    if (stack.isEmpty()) {
      return null;
    }

    return isLeaderExist(arr, stack.peek()) ? stack.peek() : null;
  }

  /**
   * <p>
   * Returns true if and only if the input variable <i>leader</i>
   * occurs in the <i>array</i> more than n/2 times false otherwise.
   *
   * </p>
   *
   * @param arr Array to check if leader exist in
   * @param leader Item being check to see if it is the leader of the specified array.
   */
  private static boolean isLeaderExist(int[] arr, Integer leader) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == leader) {
        count++;
      }
    }
    return count > arr.length / 2;

  }


}
