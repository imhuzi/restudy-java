package com.uyibai.algorithm.solution.tree;

import java.util.ArrayList;
import java.util.List;

import com.uyibai.algorithm.solution.tree.DiameterOfBinaryTree.Solution;
import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode-cn.com/problems/find-leaves-of-binary-tree/
 *
 * 给你一棵二叉树，请按以下要求的顺序收集它的全部节点：
 *
 * 依次从左到右，每次收集并删除所有的叶子节点
 * 重复如上过程直到整棵树为空
 *
 *   解题思路：
 *   ————————————————
 *  根据子树的高度来分组
 *  输入: [1,2,3,4,5]
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 * 输出: [[4,5,3],[2],[1]]
 *
 * 示例中 4, 5, 3高度都是0，2是1，1是2
 *
 *   ————————————————
 *
 * 解题思路1：
 * ————————————————
 * 本题有两个任务，一是找出叶子节点，二是把叶子节点从二叉树删去。
 *
 * 本题需要递归先序遍历，设递归函数为 TreeNode traverse(TreeNode root, List list)：
 *
 * 1、判断当前 node 是否为叶子节点，是则把当前节点装入 list，并返回 null，即告诉上一级调用当前节点已经删除；
 * 2、当前 node 不是叶子节点，对左右子结点分别调用 traverse；
 * 3、返回 node 给上一级调用，即告诉上一级，node 不是叶子节点，当前没删除。
 * ————————————————
 *
 *
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/14
 */
@Slf4j
public class FindLeavesOfBinaryTree {
  public static void main(String[] args) {
    log.info("Solution:{}",
        new FindLeavesOfBinaryTree.Solution().findLeaves(TreeUtils.createTree(new Integer[] {1, 2, 3, 4, 5})));
    log.info("Solution:{}", new FindLeavesOfBinaryTree.Solution().findLeaves(TreeUtils.createTree(null)));
  }

  static class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 思路1
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
      maxDepth(root);
      return res;
    }

    private int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      // 当前节点的叶子节点高度(最大深度)
      int h = Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
      // 后序位置：
      if (res.size() == h) {
        res.add(new ArrayList<>());
      }
      // 把所有相同高度的叶子节点放在一起
      res.get(h).add(root.getVal());
      return 1 + h;
    }

    /**
     * 思路2
     *
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves1(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      while (root != null) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        root = traverse(root, list);
        res.add(list);
      }
      return res;
    }

    private TreeNode traverse(TreeNode root, List<Integer> list) {
      if (root == null) {
        return null;
      }
      // 先序: 删除叶子节点，并记录值
      if (root.getLeft() == null && root.getRight() == null) {
        list.add(root.getVal());
        return null;
      }
      root.setLeft(traverse(root.getLeft(), list));
      root.setRight(traverse(root.getRight(), list));
      return root;
    }
  }
}
