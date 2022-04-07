package com.uyibai.base.type;

import lombok.Data;

/**
 * 2叉树
 */
@Data
public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
