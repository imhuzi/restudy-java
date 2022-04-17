package com.uyibai.algorithm.solution.tree;

import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树翻转
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/17
 */
@Slf4j
public class InvertBinaryTree {

  public static void main(String[] args) {
    TreeNode tree1 = TreeUtils.createTree(new Integer[] {4,2,7,1,3,6,9});
    TreeUtils.preOrder(tree1);
    tree1 =  new InvertBinaryTree.Solution().invertTree(tree1);
    TreeUtils.preOrder(tree1);

//    TreeNode tree2 = TreeUtils.createTree(null);
//    log.info("Solution:{}", new InvertBinaryTree.Solution().invertTree(tree2));

  }

  /**
   * 通过问题分解思路解题
   */
  static class Solution {
    TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode left = invertTree(root.getLeft());
      TreeNode right = invertTree(root.getRight());
      root.setRight(left);
      root.setLeft(right);
      return root;
    }
  }

  /**
   * 遍历思路
   */
  static class Solution1 {
    TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode left = invertTree(root.getLeft());
      TreeNode right = invertTree(root.getRight());
      root.setRight(left);
      root.setLeft(right);
      return root;
    }

    void traverse(TreeNode root) {
      if (root==null) {
        return;
      }
      TreeNode tmp = new TreeNode(root.getVal());
      tmp.setLeft(root.getRight());
      tmp.setRight(root.getLeft());

      traverse(root.getLeft());
      traverse(root.getRight());
    }
  }
}
