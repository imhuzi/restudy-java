package com.uyibai.algorithm.solution.tree;

import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 求最长直径长度
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 所谓二叉树的「直径」长度，就是任意两个结点之间的路径长度。最长「直径」并不一定要穿过根结点
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/14
 */
@Slf4j
public class DiameterOfBinaryTree {
  public static void main(String[] args) {
    log.info("Solution:{}", new Solution().diameterOfBinaryTree(TreeUtils.createTree(new Integer[]{1,2,3,4,5})));
  }

  static class Solution {
    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      maxDepth(root);
      return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = maxDepth(root.getLeft());
      int right = maxDepth(root.getRight());
      // 后序位置，顺便计算最大直径
      int myMaxDiameter = left + right;
      maxDiameter = Math.max(maxDiameter, myMaxDiameter);
      return Math.max(left, right) + 1;
    }

  }
}
