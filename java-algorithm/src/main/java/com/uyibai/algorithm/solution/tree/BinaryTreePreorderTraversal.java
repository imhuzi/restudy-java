package com.uyibai.algorithm.solution.tree;

import java.util.ArrayList;
import java.util.List;

import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/14
 */
@Slf4j
public class BinaryTreePreorderTraversal {

  public static void main(String[] args) {
//    Integer[] tree1 = new Integer[] {1, null, 2, 3};
    TreeNode tree1 = TreeUtils.createTree(new Integer[] {1, null, 2,null,null, 3},6,0);
    log.info("Tree1:{}", new Solution().preorderTraversal(tree1));
  }

  static  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList();
      if (root == null) {
        return res;
      }
      res.add(root.getVal());
      res.addAll(preorderTraversal(root.getLeft()));
      res.addAll(preorderTraversal(root.getRight()));
      return res;
    }
  }
}
