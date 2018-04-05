package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 11/22/2015.
 *
 * Segment tree data structure converts an array of data into an organized tree structure which allows queries to be
 * made on the ranges of data.
 *
 * Segment tree uses a modified "Node" object which in addition to storing a left and right child node also
 * stores the indices range the given node is responsible for; represented by a start and end node. lastly the Node object
 * also contains a value which this node correlates to for its respective range. In the case of an SumSegmentTree
 * this value is the sum from start to end indices.
 *
 * Segment tree is constructed based on original array provided. Each Node is created and attached to the tree
 * recursively in a bottom up approach with the leaf nodes being assigned values properties before its parents.
 *
 * Segment tree provide a querying capability for a particular range of the implicate array. This provides users of the
 * data structure to obtain the largest, smallest, or sum of a range a In addition to Queries being performed on segment trees they also have the ability to update index's in the implicate
 * array represented by the segment tree.
 */
public class SumSegmentTree {

  Node root;
  int max;
  public SumSegmentTree(int[] arr) {
    max = arr.length - 1;
    root = buildTree(arr, 0, max);
  }

  /**
   * Segment tree is constructed based on original array provided. Each Node is created and attached to the tree
   * recursively in a bottom up approach with the leaf nodes being assigned values properties before its parents.
   * The leaf nodes of a segment tree correspond to a particular index in the original array and they have a range
   * length of 1 as they only correspond to one index. Using the orthodox binary partition algorithm left subtree
   * is recursively built out using the left side of the array while the right subtree is recursively build out using
   * the right side of the array. Once the sub trees have recursively been built their value properties are evaluated
   * to determine the value property of the current node.
   *
   * @param arr implicate array represented by the segment tree
   * @param start start index of the array that this node is responsible for
   * @param end end index of the array that this node is responsible for
   */
  private Node buildTree(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    Node n = new Node(start, end);
    if (start == end) {
      n.sum = arr[start];
    } else {
      int mid = start + (end - start) / 2;
      n.left = buildTree(arr, start, mid);
      n.right = buildTree(arr, mid + 1, end);
      n.sum = n.left.sum + n.right.sum;
    }
    return n;
  }

  public void update(int pos, int val) {
    if (pos < 0 || pos > max) {
      throw new IndexOutOfBoundsException();
    }
    update(root, pos, val);
  }

  /**
   * Update index's in the implicate array represented by the segment tree. That is given the array [1,2,3,4] calling
   * update(0,5) will replace the first index with a 5 giving [5,2,3,4]. Calling update will also appropriately update
   * the effected nodes recursively calling the update method. The Segment tree is updated recursively and when
   * the corresponding leaf node is reached which was requested to be update the value property is modified. For
   * non-leaf Nodes their left and right subtrees are updated first recursively once the calls are returned back up
   * the stack than the left and right child nodes are evaluated to determine the value property of the current node.
   *
   * @param n Current node being evaluated
   * @param pos index in the array to be update.
   * @param val new value property to index to.
   */
  private void update(Node n, int pos, int val) {
    if (n.start == n.end) {
      n.sum = val;
    } else {
      int mid = n.start + (n.end - n.start) / 2;
      if (pos <= mid) {
        update(n.left, pos, val);
      } else {
        update(n.right, pos, val);
      }
      n.sum = n.left.sum + n.right.sum;
    }
  }

  public int sumRange(int i, int j) {
    if (i < 0 || j > max || i > max || j < 0) {
      throw new IndexOutOfBoundsException();
    }
    return sumRange(root, i, j);
  }

  /**
   * returns the value property associated with the range provided start and end inclusive. Using orthodox Binary
   * search algorithm navigate down the segment tree looking for the range provided.
   *
   * @param n Current node being evaluated
   * @param start start index of the array that this node is responsible for
   * @param end end index of the array that this node is responsible for
   * @return Value associated with the index range provided
   */
  private int sumRange(Node n, int start, int end) {
    if (n.start == start && n.end == end) {
      return n.sum;
    } else {
      int mid = n.start + (n.end - n.start) / 2;
      if (end <= mid) {
        return sumRange(n.left, start, end);
      } else if (start >= mid + 1) {
        return sumRange(n.right, start, end);
      } else {
        return sumRange(n.left, start, mid) + sumRange(n.right, mid + 1, end);
      }
    }
  }

  class Node {

    int start, end, sum = 0;
    Node left, right;

    Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
