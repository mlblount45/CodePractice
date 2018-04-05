package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 12/19/2015.
 */
public class MaxSegmentTree {

  Node root;
  int max;
  public MaxSegmentTree(int[] arr) {
    max = arr.length - 1;
    root = buildTree(arr, 0, max);
  }

  private Node buildTree(int[] arr, int start, int end) {
    if (start > end) {
      return null;
    }
    Node n = new Node(start, end);
    if (start == end) {
      n.max = arr[start];
    } else {
      int mid = start + (end - start) / 2;
      n.left = buildTree(arr, start, mid);
      n.right = buildTree(arr, mid + 1, end);
      n.max = Math.max(n.left.max, n.right.max);
    }
    return n;
  }

  public void update(int i, int val) {
    if (i < 0 || i > max) {
      throw new IndexOutOfBoundsException();
    }
    update(root, i, val);
  }

  private void update(Node node, int i, int val) {
    if (node.start == node.end) {
      node.max = val;
    } else {
      int mid = node.start + (node.end - node.start) / 2;
      if (i <= mid) {
        update(node.left, i, val);
      } else {
        update(node.right, i, val);
      }
      node.max = Math.max(node.left.max, node.right.max);
    }
  }

  public int maxRange(int i, int j) {
    if (i < 0 || j > max || i > max || j < 0) {
      throw new IndexOutOfBoundsException();
    }
    return maxRange(root, i, j);
  }

  private int maxRange(Node node, int i, int j) {
    if (node.start == i && node.end == j) {
      return node.max;
    }
    int mid = node.start + (node.end + node.start) / 2;
    if (i >= mid + 1) {
      return maxRange(node.right, i, j);
    } else if (j <= mid) {
      return maxRange(node.left, i, j);
    } else {
      return Math.max(maxRange(node.left, i, mid), maxRange(node.right, mid + 1, j));
    }
  }

  class Node {

    int start, end, max = Integer.MIN_VALUE;
    Node left, right;

    Node(int i, int j) {
      start = i;
      end = j;
    }
  }

}
