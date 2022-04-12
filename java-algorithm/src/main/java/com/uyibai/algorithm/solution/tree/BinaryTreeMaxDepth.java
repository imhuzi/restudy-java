package com.uyibai.algorithm.solution.tree;

import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 二叉树 最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/11
 */
@Slf4j
public class BinaryTreeMaxDepth {

  public static void main(String[] args) {
    /**
     *            1
     *          /  \
     *        /     \
     *      /        \
     *     2           5
     *    /  \        /
     *   3    4      6
     *              /
     *             7
     */
    TreeNode l3 = new TreeNode(3);
    TreeNode l4 = new TreeNode(4);
    TreeNode l7 = new TreeNode(7);
    TreeNode l6 = new TreeNode(6, l7, null);
    TreeNode l5 = new TreeNode(5, l6, null);
    TreeNode l2 = new TreeNode(2, l3, l4);

    TreeNode root = new TreeNode(1, l2, l5);

    log.info("BinaryTreeMaxDepth:{}", new Solution().maxDepth(root));
    log.info("BinaryTreeMaxDepth2:{}", new Solution2().maxDepth(root));
  }

  /**
   * 问题分解：动态规划思路(递归)
   */
  static class Solution {
    public int maxDepth(TreeNode tree) {
      // 到达叶子节点
      if (tree == null) {
        return 0;
      }
      int leftDeep = maxDepth(tree.getLeft());
      int rightDeep = maxDepth(tree.getRight());
      // 后续位置,先遍历左子树，在遍历右子树，然后取最大值 + root
      return 1 + Math.max(leftDeep, rightDeep);
    }
  }

  static class Solution2 {
    // 记录最大深度
    int max = 0;
    // 记录遍历到的节点深度
    int depth = 0;

    public int maxDepth(TreeNode tree) {
      traverse(tree);
      return max;
    }
    // 遍历框架
    public void traverse(TreeNode tree) {
      if (tree == null) {
        // 到达叶子节点，更新最大深度
        max = Math.max(max, depth);
        return;
      }
      // 前序位置
      depth++;
      traverse(tree.getLeft());
      traverse(tree.getRight());
      depth--;
      //后序位置
    }
  }
}
