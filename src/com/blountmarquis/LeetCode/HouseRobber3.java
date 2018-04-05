package com.blountmarquis.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mlblount on 3/11/2016.
 */
public class HouseRobber3 {

  public int rob(TreeNode root) {
    List<Integer> sums = getLevelSums(root);
    return getLargestNonAdjacentSum(sums, 0, 0);
  }

  private List<Integer> getLevelSums(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    TreeNode temp = null;
    List<Integer> sums = new ArrayList<>();
    while (!q.isEmpty()) {
      int size = q.size();
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        temp = q.remove();
        levelSum += temp.val;
        if (temp.left != null) {
          q.add(temp.left);
        }
        if (temp.right != null) {
          q.add(temp.right);
        }
      }
      sums.add(levelSum);
    }
    return sums;
  }

  private int getLargestNonAdjacentSum(List<Integer> sums, int index, int sum) {
    if (index >= sums.size()) {
      return 0;
    }

    sum += Math.max(getLargestNonAdjacentSum(sums, index + 2, sum + sums.get(index)),
        getLargestNonAdjacentSum(sums, index + 1, sum));
    return sum;
  }

  private class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;
  }
}
