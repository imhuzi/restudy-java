package com.uyibai.algorithm.solution.tree;

import java.util.LinkedList;
import java.util.List;

import com.uyibai.base.type.TreeNode;

import lombok.extern.slf4j.Slf4j;


/**
 * tree 相关工具类
 *
 * 二叉树一般使用顺序存储(完全二叉树)或者链式存储，
 *
 * 顺序存储：如果 0位置不存储节点。下标i，对于左节点 2i, 有节点:2i+1, 相当于是按层遍历的方式存储.
 * 顺序存储：如果 0位置存储节点。下标i，对于左节点 2i+1, 有节点:2i+2, 相当于是按层遍历的方式存储.
 *
 *
 * @author : Hui.Wang [huzi.wh@gmail.com]
 * @version : 1.0
 * @date  : 2022/4/12
 */
@Slf4j
public class TreeUtils {
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
   * 二叉树顺序存储 转为 链式存储
   *
   *
   * 用一维数组存储二叉树中的结点，并且结点的存储位置，也就是数组的下标要能体现结点之间的逻辑关系
   * 方案1：
   * 已知双亲结点为i: 左孩子的结点为（2i+1）,右孩子的结点为（2i+2）
   * 已知孩子结点为i: 双亲结点为：（i-1）/2
   * 方案2：arr[0] 会浪费掉，不存储内容
   * 已知双亲结点为i: 左孩子的结点为（2i）,右孩子的结点为（2i+1）
   * 已知孩子结点为i: 双亲结点为：i/2
   *
   * @param arr 数组
   * @param n  树的节点
   * @param pos 数组下标
   * @return 树
   */
  public static TreeNode createTree(Integer[] arr, int n, int pos) {
    if (arr != null && pos < n) {
      TreeNode node = new TreeNode(arr[pos]);
      int nextLeftPos = pos * 2 + 1;
      if (nextLeftPos < n && arr[nextLeftPos] != null) {
        node.setLeft(createTree(arr, n, nextLeftPos));
      }
      int nextRightPos = pos * 2 + 2;
      if (nextRightPos < n && arr[nextRightPos] != null) {
        node.setRight(createTree(arr, n, nextRightPos));
      }
      return node;
    }
    return null;
  }

  public static int[] toArr() {

    return null;
  }

  public static TreeNode createTree(Integer[] arr) {
    if (arr == null) {

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
      return root;
    }

    return createTree(arr, arr.length, 0);
  }

  /**
   * 前序遍历
   */
  public static List<Integer> preOrder(TreeNode tree) {
    List<Integer> res = traverse(tree, TRAVERSE_TYPE_PRE);
    log.info("preOrder:{}", res);
    return res;
  }

  /**
   * 中序遍历
   */
  public static List<Integer> inOrder(TreeNode tree) {
    List<Integer> res = traverse(tree, TRAVERSE_TYPE_IN);
    log.info("inOrder:{}", res);
    return res;
  }

  /**
   * 后续遍历
   */
  public static List<Integer> postOrder(TreeNode tree) {
    List<Integer> res = traverse(tree, TRAVERSE_TYPE_POST);
    log.info("postOrder:{}", res);
    return res;
  }


  /**
   * 内部 遍历结构
   *
   * @param node
   * @param orderType
   * @return
   */
  private static List<Integer> traverse(TreeNode node, int orderType) {
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
