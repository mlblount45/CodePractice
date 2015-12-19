package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 11/22/2015.
 */
public class SumSegmentTree {
    class Node {
        int start, end, sum = 0;
        Node left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Node root;
    int max;
    public SumSegmentTree(int[] arr) {
        max = arr.length - 1;
        root = buildTree(arr, 0, max);
    }

    private Node buildTree(int[] arr, int start, int end) {
        if (start > end) return null;
        Node n = new Node(start, end);
        if (start == end) n.sum = arr[start];
        else {
            int mid = start + (end - start) / 2;
            n.left = buildTree(arr, start, mid);
            n.right = buildTree(arr, mid + 1, end);
            n.sum = n.left.sum + n.right.sum;
        }
        return n;
    }

    public void update(int i, int val) {
        if(i < 0 || i > max) throw new IndexOutOfBoundsException();
        update(root, i, val);
    }

    private void update(Node n, int pos, int val) {
        if (n.start == n.end) n.sum = val;
        else {
            int mid = n.start + (n.end - n.start) / 2;
            if (pos <= mid) update(n.left, pos, val);
            else update(n.right, pos, val);
            n.sum = n.left.sum + n.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j > max || i > max || j < 0) throw new IndexOutOfBoundsException();
        return sumRange(root, i, j);
    }

    private int sumRange(Node n, int start, int end) {
        if (n.start == start && n.end == end) return n.sum;
        else {
            int mid = n.start + (n.end - n.start) / 2;
            if (end <= mid) return sumRange(n.left, start, end);
            else if (start >= mid + 1) return sumRange(n.right, start, end);
            else return sumRange(n.left, start, mid) + sumRange(n.right, mid + 1, end);
        }
    }
}
