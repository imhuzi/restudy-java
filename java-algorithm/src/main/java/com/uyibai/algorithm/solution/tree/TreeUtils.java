package com.uyibai.algorithm.solution.tree;

import com.uyibai.base.type.TreeNode;


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
public class TreeUtils {
  /**
   * 二叉树顺序存储 转为 链式存储
   *
   * @param arr 数组
   * @param n  树的节点
   * @param pos 数组下标
   * @return 树
   */
  public static TreeNode createTree(int[] arr, int n, int pos) {
    if (arr != null && pos < n) {
      TreeNode node = new TreeNode(arr[pos]);
      node.setLeft(createTree(arr, n, pos * 2));
      node.setRight(createTree(arr, n, pos * 2 + 1));
      return node;
    }
    return null;
  }

  public static int[] toArr() {

    return null;
  }
}
