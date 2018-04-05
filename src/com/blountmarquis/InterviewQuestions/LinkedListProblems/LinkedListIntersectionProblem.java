package com.blountmarquis.InterviewQuestions.LinkedListProblems;

import com.blountmarquis.datastructures.LinkedList;

/**
 * Created by MLBlount on 4/19/2015.
 *
 * THIS CODE IS NOT TO BE TRUST HAS NOT BEEN PROPERLY TESTED!
 */
@Deprecated
/**Deprecated until properly tested*/
public class LinkedListIntersectionProblem {

  public LinkedList.Node<Integer> getIntersectionNode(LinkedList<Integer> l1,
      LinkedList<Integer> l2) {

    int l1Size = getListSize(l1);
    int l2Size = getListSize(l2);

    LinkedList.Node<Integer> l1Pointer = l1.getHead();
    LinkedList.Node<Integer> l2Pointer = l2.getHead();

    if (l1Size > l2Size) {
      for (int i = 0; i < l1Size - l2Size && l1Pointer != null; i++) {
        l1Pointer = l1Pointer.getNext();
      }
    } else if (l2Size > l1Size) {
      for (int i = 0; i < l2Size - l1Size && l1Pointer != null; i++) {
        l2Pointer = l2Pointer.getNext();
      }
    }

    LinkedList.Node<Integer> intersectingNode = null;
    while (l1Pointer != null && l2Pointer != null && l1Pointer != l2Pointer) {
      if (l1Pointer == l2Pointer) {
        intersectingNode = l1Pointer;
      }
      l1Pointer = l1Pointer.getNext();
      l2Pointer = l2Pointer.getNext();
    }
    return intersectingNode;
  }

  private int getListSize(LinkedList<Integer> l) {
    int count = 0;
    LinkedList.Node<Integer> ws = l.getHead();
    while (ws != null) {
      ws = ws.getNext();
      count++;
    }
    return count++;
  }
}


