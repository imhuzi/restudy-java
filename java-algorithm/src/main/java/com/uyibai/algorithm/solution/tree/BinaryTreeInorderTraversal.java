package com.uyibai.algorithm.solution.tree;


import com.uyibai.base.type.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表 存储的 二叉树中序遍历
 */
@Slf4j
public class BinaryTreeInorderTraversal {

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
        // [3, 2, 4, 1, 7, 6, 5]
        log.info("Solution:{}", new Solution().inorderTraversal(root));
        ;
    }

    static class Solution {

        /**
         * 动态规划思路
         * 定义：输入一个节点，返回该节点为根的二叉树的中序遍历
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            res.addAll(inorderTraversal(root.getLeft()));
            res.add(root.getVal());
            res.addAll(inorderTraversal(root.getRight()));
            return res;
        }
    }
}
