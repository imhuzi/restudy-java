package com.uyibai.algorithm;

import com.uyibai.base.type.TreeNode;

import java.util.LinkedList;

public class TreePrint {

    public static void main(String[] args) {
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l7 = new TreeNode(7);
        TreeNode l6 = new TreeNode(6, l7, null);
        TreeNode l5 = new TreeNode(5, l6, null);
        TreeNode l2 = new TreeNode(2, l3, l4);

        TreeNode root = new TreeNode(1, l2, l5);
        // 递归遍历
        traverse(root);
    }


    /**
     * 二叉树递归遍历
     *
     * @param node
     */
    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前序
//        System.out.println("pre:" + node.getVal());
        traverse(node.getLeft());
        // 中序
//        System.out.println("mid:" + node.getVal());
        traverse(node.getRight());
        // 后序
        System.out.println("after:" + node.getVal());
    }

    public static void preTraverse(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null && !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.getLeft();
            } else {
                TreeNode node = stack.pop();
                pNode = node.getRight();
            }
        }
    }
}
