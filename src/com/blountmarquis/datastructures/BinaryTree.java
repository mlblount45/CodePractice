package com.blountmarquis.datastructures;

import java.util.Stack;

/**
 * Created by MLBlount on 10/13/2014.
 */
public class BinaryTree<T extends Comparable<T>> {

  Node root;

  public BinaryTree() {
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  private static <E extends Comparable<E>> Node<E> createMinimalBST(E[] a, int start, int end) {
    if (end < start) {
      return null;
    }

    int mid = (end + start) / 2;
    Node n = new Node<E>(a[mid]);
    n.left = createMinimalBST(a, start, mid - 1);
    n.right = createMinimalBST(a, mid + 1, end);
    return n;
  }

  public static <E extends Comparable<E>> Node<E> createMinimalBST(E[] a) {
    return createMinimalBST(a, 0, a.length - 1);
  }

  private static <E extends Comparable<E>> boolean isBST(Node<E> n, E min, E max) {
    if (n == null) {
      return true;
    }

    if ((min != null && min.compareTo(n.value) > 0) || (max != null
        && max.compareTo(n.value) <= 0)) {
      return false;
    }

    if (!isBST(n.left, min, n.value) || !isBST(n.right, n.value, max)) {
      return false;
    }

    return true;
  }

  public static <E extends Comparable<E>> boolean isBST(Node<E> n) {
    return isBST(n, null, null);
  }

  public static <T extends Comparable<T>> BinaryTree<T> constructTreeFromInOrderList(T[] arr) {
    if (arr == null) {
      return null;
    }
    BinaryTree tree = new BinaryTree();
    constructTreeFromInOrderList(tree, arr, 0, arr.length - 1);
    return tree;
  }

  private static <T extends Comparable<T>> void constructTreeFromInOrderList(BinaryTree tree,
      T[] arr, int start, int end) {
    if (start >= end) {
      return;
    }
    Integer mid = (start + end) / 2;
    tree.insert(arr[mid]);
    constructTreeFromInOrderList(tree, arr, start, mid - 1);
    constructTreeFromInOrderList(tree, arr, mid + 1, end);
  }

  public Node<T> getRoot() {
    return this.root;
  }

  public void insert(T value) {
    this.root = insert(this.root, value);
  }

  private Node<T> insert(Node node, T value) {
    if (node == null) {
      node = new Node(value);
    } else {
      if (node.value.compareTo(value) >= 0) {
        node.left = insert(node.left, value);
      }
      if (node.value.compareTo(value) < 0) {
        node.right = insert(node.right, value);
      }
    }
    return node;
  }

  public void iterativePreOrder() {
    if (this.root == null) {
      return;
    }
    iterativePreOrder(this.root);
  }

  private void iterativePreOrder(Node<Integer> node) {
    Stack<Node> stack = new Stack<Node>();
    for (; ; ) {
      System.out.print(node.value + " ,");
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        node = node.left;
      } else if (stack.isEmpty() == false) {
        node = stack.pop();
      } else {
        break;
      }
    }
  }

  public void preOrderTraversalPrint() {
    preOrderTraversalPrint(this.root);
  }

  public void preOrderTraversalPrint(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.value + ", ");
    preOrderTraversalPrint(node.left);
    preOrderTraversalPrint(node.right);
  }

  public void inOrderTraversalPrint() {
    inOrderTraversalPrint(this.root);
  }

  private void inOrderTraversalPrint(Node node) {
    if (node == null) {
      return;
    }

    inOrderTraversalPrint(node.left);
    System.out.print(node.value + ", ");
    inOrderTraversalPrint(node.right);
  }

  public void postOrderTraversalPrint() {
    postOrderTraversalPrint(this.root);
  }

  public void postOrderTraversalPrint(Node node) {
    if (node == null) {
      return;
    }

    postOrderTraversalPrint(node.left);
    postOrderTraversalPrint(node.right);
    System.out.print(node.value + ", ");
  }

  public Node<T> search(T val) {
    if (val == null) {
      return null;
    }
    Node<T> node = this.root;
    while (node != null) {
      if (val == node.value) {
        return node;
      } else if (val.compareTo(node.value) > 0) {
        node = node.right;
      } else {
        node = node.left;
      }
    }

    return null;
  }

  /**
   * <p>Successor is the next node in ordered fashion.</p>
   * <p> There are two scenarios in obtaining the successor of a given node.</p>
   * <p>
   * Scenario 1:
   * If the right subtree of a given node <i>X</i>  is not empty, then the successor of X
   * is the leftmost node in X's right subtree.
   * </p>
   * <p>
   * Scenario 2:
   * If the right subtree of Node <i>X</i>  is empty and <i>X</i>  has a successor,
   * then the Successor is the lowest ancestor of <i>X</i>  whose left child is also an ancestor of X.
   * </p>
   */
  public Node<T> successor(Node nodeOfInterest) {
    if (nodeOfInterest == null) {
      return nodeOfInterest;
    }

    if (nodeOfInterest.right != null) {
      return minimum(nodeOfInterest.right);
    }

    Node ws = this.root;
    Node successor = null;
    while (ws != null) {
      if (ws.value.compareTo(nodeOfInterest.value) > 0) {
        successor = ws;
        ws = ws.left;
      } else if (ws.value.compareTo(nodeOfInterest.value) < 0) {
        ws = ws.right;
      } else {
        break;
      }
    }
    return successor;
  }

  private Node<T> minimum(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  /**
   * Predecessor is the previous node in ordered fashion <br>
   * <br>
   * There are two scenarios in obtaining the predecessor of a given node.
   * <br><br>
   * Scenario 1: If the left subtree of a given node <i>X</i> is not empty, then the predecessor of X
   * is the rightmost node in X's left subtree.
   * <br>
   * Scenario 2: If the left subtree of a given node <i>X</i> is empty, then the predecessor of X
   * is the lowest ancestor of X whose right child is also an ancestor of X.
   */
  public Node<T> predecessor(Node nodeOfInterest) {
    if (nodeOfInterest == null) {
      return null;
    }

    if (nodeOfInterest.left != null) {
      return maximum(nodeOfInterest.left);
    }

    Node ws = this.root;
    Node predecessor = null;

    while (ws != null) {
      if (ws.value.compareTo(nodeOfInterest.value) < 0) {
        predecessor = ws;
        ws = ws.right;
      } else if (ws.value.compareTo((nodeOfInterest.value)) > 0) {
        ws = ws.left;
      } else {
        break;
      }
    }
    return predecessor;
  }

  private Node<T> maximum(Node node) {
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  public void delete(T val) {
    Node node = search(val);
    if (node == null) {
      return;
    }

    if (node.right == null) {
      node = node.left;
    } else if (node.left == null) {
      node = node.right;
    } else {
      Node<T> temp = minimum(node.right);
      T tempValue = temp.value;
      node.value = tempValue;
    }

  }

  public Node<T> getParent(Node<T> node) {
    if (node == null) {
      return null;
    }
    Node parent = null;
    Node ws = this.root;
    while (ws != null) {
      if (ws.value.compareTo(node.value) == 0) {
        return parent;
      }
      if (ws.value.compareTo(node.value) > 0) {
        parent = ws;
        ws = ws.left;
      } else {
        parent = ws;
        ws = ws.right;
      }
    }
    return parent;
  }

  public int getHeight() {
    Node n = this.root;
    return getHeight(n);
  }

  private int getHeight(Node node) {
    if (node == null) {
      return 1;
    }

    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  public int getSumOfHeight(int height) {
    Node n = this.root;
    return getSumOfHeight(n, height - 1);
  }

  private int getSumOfHeight(Node n, int height) {
    if (height == 0) {
      return (Integer) n.value;
    }

    int sum = 0;
    if (n.left != null) {
      sum += getSumOfHeight(n.left, height - 1);
    }
    if (n.right != null) {
      sum += getSumOfHeight(n.right, height - 1);
    }
    return sum;
  }

  public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private Node left;
    private Node right;
    private T value;
    public Node() {
    }
    private Node(T value) {
      this.value = value;
    }

    @Override
    public int compareTo(Node<T> o) {
      return value.compareTo(o.value);
    }

    @Override
    public String toString() {
      return "Node{" +
          "value=" + value +
          '}';
    }
  }

}
