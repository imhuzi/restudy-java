package com.uyibai.algorithm.solution.tree;

import java.util.ArrayList;
import java.util.List;

import com.uyibai.algorithm.solution.tree.BinaryTreePreorderTraversal.Solution;
import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树 后续遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/14
 */
@Slf4j
public class BinaryTreePostorderTraversal {

  public static void main(String[] args) {
//    Integer[] tree1 = new Integer[] {1, null, 2, 3};
    TreeNode tree1 = TreeUtils.createTree(new Integer[] {1, null, 2,null,null, 3},6,0);
    log.info("Tree1:{}", new BinaryTreePreorderTraversal.Solution().preorderTraversal(tree1));
  }

  static  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList();
      if (root == null) {
        return res;
      }
      res.addAll(preorderTraversal(root.getLeft()));
      res.addAll(preorderTraversal(root.getRight()));
      res.add(root.getVal());
      return res;
    }
  }
}
