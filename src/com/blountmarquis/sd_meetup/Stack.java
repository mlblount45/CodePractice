package com.blountmarquis.sd_meetup;

import java.util.EmptyStackException;

/**
 * Created by MLBlount on 8/2/2015.
 */

/**
 * This Stack representation keeps track of the minimum integer in the stack.
 * To achieve this the class contains a second stack pointer (min) which is only added to
 * when the min stack is empty, or when the value being pushed is less than
 * the value currently on the top of the min stack. The min stack top value is only popped when the
 * min stack top value and the complete stack top value are the same on a pop() call.
 * The min() method returns the value of the min stack top.
 */
public class Stack {

  private StackNode top;
  private StackNode min;

  public static void main(String[] args) {
    Stack s = new Stack();
    s.push(6);
    s.push(2);
    s.push(4);
    s.push(5);
    s.push(1);
    System.out.println(s.min());
    s.pop();
    s.pop();
    s.pop();
    s.pop();
    System.out.println(s.min());
    s.push(3);
    s.push(7);
    System.out.println(s.min());
  }

  public void push(int val) {
    StackNode n = new StackNode(val);

    if (top == null) {
      top = n;
      min = n;
    } else {
      if (n.val < min.val) {
        n.next = min;
        min = n;
      }
      n.next = top;
      top = n;
    }
  }

  public int pop() {
    if (top == null) {
      throw new EmptyStackException();
    }
    if (top == min) {
      min = min.next;
    }
    int temp = top.val;
    top = top.next;
    return temp;
  }

  public int min() {
    return min.val;
  }

  private class StackNode {

    int val;
    StackNode next;

    public StackNode(int val) {
      this.val = val;
    }
  }
}
