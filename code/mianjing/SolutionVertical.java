package com.mianjing;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
/**
 * Created by Tian on 2017/4/27.
 */
public class SolutionVertical {

    public static void main(String[] args) {
        TreeNode root = dserialize("{3,9,20,#,#,15,7}");
        String data = serialize(root);
        System.out.println(data);

        System.out.println(vertical(root).toString());
    }

    private static List<List<Integer>> vertical(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        //bfs and also remember the order by TreeMap
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        Queue<Integer> col = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        col.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int cindex = col.poll();
            if (map.containsKey(cindex)) {
                map.get(cindex).add(node.val);
                System.out.println("add" + node.val + "i" + cindex);
            } else {
                ArrayList<Integer> nl = new ArrayList<Integer>();
                nl.add(node.val);
                map.put(cindex, nl);
                System.out.println("new" + node.val + "i" + cindex);
            }

            if (node.left != null) {
                queue.add(node.left);
                col.add(cindex - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                col.add(cindex + 1);
            }
        }

        System.out.println(map);
        for (int n : map.keySet()) {
            res.add(map.get(n));
        }

        return res;
    }

    private static String serialize(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            sb.append(node == null ? "#" : node.val);
        }

        return sb.toString();

    }

    private static TreeNode dserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int index = 0;
        boolean isLeftNode = true;

        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
                if (isLeftNode) {
                    list.get(index).left = node;
                } else {
                    list.get(index).right = node;
                }
                list.add(node);
            }

            if (!isLeftNode) {
                index++;
            }

            isLeftNode = !isLeftNode;
        }

        return root;
    }
}
