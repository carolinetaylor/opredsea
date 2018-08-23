package com.fb;

/**
 * Created by Tian on 2017/6/27.
 */
public class PrintTree {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public static void main() {
        int[] array = {0,1,2,3,4,5,6,7,8};
        TreeNode root;
        for (int val : array) {
            root = buildBST(null, val);
        }
    }

    public static TreeNode buildBST(TreeNode root, int val) {
        return null;
    }

}
