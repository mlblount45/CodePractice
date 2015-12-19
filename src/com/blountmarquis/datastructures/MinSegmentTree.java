package com.blountmarquis.datastructures;

/**
 * Created by MLBlount on 12/18/2015.
 */
public class MinSegmentTree {
    public class Node {
        int start, end, min = Integer.MAX_VALUE;
        Node left, right;

        public Node(int i, int j) {
            start = i;
            end = j;
        }
    }

    Node root;
    int max;

    public MinSegmentTree(int[] arr) {
        max = arr.length - 1;
        root = buildTree(arr, 0, max);
    }

    private Node buildTree(int[] arr, int start, int end) {
        if (start > end) return null;
        Node n = new Node(start, end);
        if (start == end) n.min = arr[start];
        else {
            int mid = start + (end - start) / 2;
            n.left = buildTree(arr, start, mid);
            n.right = buildTree(arr, mid + 1, end);
            n.min = Math.min(n.left.min, n.right.min);
        }
        return n;
    }

    public void update(int i, int val) {
        if (i < 0 || i > max) throw new IndexOutOfBoundsException();
        update(root, i, val);
    }

    private void update(Node node, int pos, int val) {
        if (node.start == node.end) node.min = val;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid) update(node.left, pos, val);
            else update(node.right, pos, val);
            node.min = Math.min(node.left.min, node.right.min);
        }
    }

    public int minRange(int i, int j) {
        if (i < 0 || j > max || i > max || j < 0) throw new IndexOutOfBoundsException();
        return minRange(root, i, j);
    }

    private int minRange(Node node, int start, int end) {
        if (node.start == start && node.end == end) return node.min;
        int mid = node.start + (node.end - node.start) / 2;
        if (end <= mid) return minRange(node.left, start, end);
        else if (start >= mid + 1) return minRange(node.right, start, end);
        else return Math.min(minRange(node.left, start, mid), minRange(node.right, mid + 1, end));
    }
}
