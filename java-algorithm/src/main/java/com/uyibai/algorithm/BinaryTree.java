package com.uyibai.algorithm;

import com.uyibai.base.type.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 */
@Slf4j
public class BinaryTree {
    /**
     * 遍历类型:前序
     */
    private static final int TRAVERSE_TYPE_PRE = 1;
    /**
     * 遍历类型:中序
     */
    private static final int TRAVERSE_TYPE_IN = 2;
    /**
     * 遍历类型:后续
     */
    private static final int TRAVERSE_TYPE_POST = 3;


    /**
     * 前序遍历
     */
    public void preOrder(TreeNode tree) {
        log.info("preOrder:{}", traverse(tree, TRAVERSE_TYPE_PRE));
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode tree) {
        log.info("inOrder:{}", traverse(tree, TRAVERSE_TYPE_IN));
    }

    /**
     * 后续遍历
     */
    public void postOrder(TreeNode tree) {
        log.info("postOrder:{}", traverse(tree, TRAVERSE_TYPE_POST));
    }

    /**
     * 层序遍历
     *
     * @param tree
     */
    public void levelOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);
        // 从上到下遍历二叉树的每层
        while (!q.isEmpty()) {
            // 从左到右遍历每一层的每个节点
            for (int i = 0, size = q.size(); i < size; i++) {
                TreeNode cur = q.poll();
                // 将下一层节点放入队列
                if (cur.getLeft() != null) {
                    q.offer(cur.getLeft());
                }
                if (cur.getRight() != null) {
                    q.offer(cur.getRight());
                }
            }
        }
    }

    /**
     * 计算 树的 节点树: 每个节点的左右子树各有多少节点？
     *
     * @param tree
     * @return
     */
    public int count(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftCount = count(tree.getLeft());
        int rightCount = count(tree.getRight());
        // 左子树 count + 右子树count + 根节点
        return leftCount + rightCount + 1;
    }

    /**
     * 二叉树 层数: 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
     *
     * @param tree
     * @return
     */
    public int levelTraverse(TreeNode tree) {
        return levelTraverse(tree, 1);
    }

    private int levelTraverse(TreeNode tree, int level) {
        if (tree == null) {
            return 0;
        }
        int leftLevel = levelTraverse(tree.getLeft(), level + 1);
        int leftRight = levelTraverse(tree.getRight(), level + 1);
        return Math.max(leftLevel, leftRight);
    }

    /**
     * 二叉树 高度
     *
     * @param tree
     * @return
     */
    public int heightTraverse(TreeNode tree) {
        return levelTraverse(tree, 0) - 1;
    }

    /**
     * 二叉树 深度
     *
     * @param tree
     * @return
     */
    public int depthTraverse(TreeNode tree) {
        return levelTraverse(tree, 0) - 1;
    }


    /**
     * 内部 遍历结构
     *
     * @param node
     * @param orderType
     * @return
     */
    private List<Integer> traverse(TreeNode node, int orderType) {
        LinkedList<Integer> res = new LinkedList<>();
        if (node == null) {
            return res;
        }

        // 前序
        if (orderType == TRAVERSE_TYPE_PRE) {
//            System.out.println("preOrder:" + node.getVal());
            res.add(node.getVal());
        }
        res.addAll(traverse(node.getLeft(), orderType));
        // 中序
        if (orderType == TRAVERSE_TYPE_IN) {
//            System.out.println("inOrder:" + node.getVal());
            res.add(node.getVal());
        }
        res.addAll(traverse(node.getRight(), orderType));
        // 后序
        if (orderType == TRAVERSE_TYPE_POST) {
//            System.out.println("afterOrder:" + node.getVal());
            res.add(node.getVal());
        }

        return res;
    }

}
