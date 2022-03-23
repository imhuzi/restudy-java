package com.uyibai.algorithm;

import com.uyibai.base.type.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树遍历：前，中，后序 表示的是节点与他的左右子节点遍历打印的先后顺序。
 */
@Slf4j
public class TreeTraverse {

    public static void main(String[] args) {
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l7 = new TreeNode(7);
        TreeNode l6 = new TreeNode(6, l7, null);
        TreeNode l5 = new TreeNode(5, l6, null);
        TreeNode l2 = new TreeNode(2, l3, l4);

        TreeNode root = new TreeNode(1, l2, l5);
        // 递归遍历
//        traverse(root);
//        log.info("pre:{}", preOrderTraverse(root));
//        traverseLevel(root, 1);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrder(root);
        binaryTree.inOrder(root);
        binaryTree.postOrder(root);

        log.info("BinaryTreeCount:{}", binaryTree.count(root));
        log.info("BinaryTreeLevel:{}", binaryTree.levelTraverse(root));
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

    public static List<Integer> preOrderTraverse(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前:
        res.add(root.getVal());
        res.addAll(preOrderTraverse(root.getLeft()));
        // 中
        res.addAll(preOrderTraverse(root.getRight()));
        // 后
        return res;
    }

    public static void traverseLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        log.info("节点{} 在 第{} 层", root.getVal(), level);
        traverseLevel(root.getLeft(), level + 1);
        traverseLevel(root.getRight(), level + 1);
    }

}
