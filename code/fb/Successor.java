package com.fb;

/**
 * Created by Tian on 2017/5/4.
 */
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Successor {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 5,8, 9, 10};
        Successor sc = new Successor();
        TreeNode root = sc.buildBST(nums, 0, nums.length - 1);
        TreeNode p = new TreeNode(1);
        sc.inorder(root);
        System.out.println("");
        System.out.println(sc.inorderSuccessor(root, p).val);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(nums[(start + end)/2]);
        node.left = buildBST(nums, start, (start + end)/2 - 1);
        node.right = buildBST(nums, (start + end)/2 + 1, end);
        return node;
    }

    private TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        /* find the node in BST
           if no found return null
           if found
              if has right node, go to most of the left node
              if no right node, find last root which has left node, by
              going left(smaller node) in BST
              if it is the most right node, return null (successor is null)
         */
        TreeNode successorRoot = null;

        while (root != null && root.val != node.val) {
            System.out.println(root.val);
            if (node.val < root.val) {
                successorRoot = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successorRoot;
        }

        TreeNode nt = root.right;
        System.out.println(root.right.val);

        while (nt.left != null) {
            nt = nt.left;
        }
        return nt;
    }
}
