package com.uyibai.base.type;

import lombok.Data;
import lombok.val;

/**
 * 2叉树
 */
@Data
public class TreeNode {
    Integer val;
    TreeNode left, right;

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
